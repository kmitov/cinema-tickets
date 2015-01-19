package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.*;
import com.cinema.tickets.entity.Projection;
import com.cinema.tickets.service.MovieService;
import com.cinema.tickets.service.ProjectionService;
import com.cinema.tickets.service.ReservationService;
import com.cinema.tickets.service.impl.MovieServiceImpl;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cinema.tickets.utils.MessagingUtil.addMessage;

/**
 * Created by kmitov on 1/14/15.
 */
public class TheatreBean {

    private ReservationService reservationService;
    private MovieService movieService;
    private ProjectionService projectionService;

    private List<TheatreRowDto> rows;
    private List<TicketDto> reservedTickets;
    private List<TicketDto> tickets;

    private Long projectionId;
    private Long theatreId;
    private Long userId;

    private MovieDto selectedMovie;
    private ProjectionDto selectedProjection;

    private static final int MAX_SEATS_PER_ROW = 12;

    //Dummy constructor to produce an example theatre
    public TheatreBean(ReservationService reservationService, MovieService movieService, ProjectionService projectionService) {
        this.reservationService = reservationService;
        this.movieService = movieService;
        this.projectionService = projectionService;
        tickets = new ArrayList<TicketDto>();
        initializeTheatre();
    }

    private void initializeTheatre() {
        rows = new ArrayList<TheatreRowDto>();
        for(int i = 1; i<7; i++){
            TheatreRowDto rowDto = new TheatreRowDto();
            rowDto.setNumber(new Long(i));
            List<TheatreSeatDto> seats = new ArrayList<TheatreSeatDto>();
            for(int k = 1; k < MAX_SEATS_PER_ROW - i; k++){
                TheatreSeatDto seatDto = new TheatreSeatDto();
                seatDto.setRowNumber(new Long(i));
                seatDto.setNumber(new Long(k));
                seatDto.setPrice(10);
                seats.add(seatDto);
            }
            rowDto.setSeats(seats);
            rows.add(rowDto);
        }
    }

    public List<TheatreRowDto> getRows() {
        return rows;
    }

    public void reservePlace() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String seatAndRowIds = params.get("seatId");
        if(seatAndRowIds != null && !seatAndRowIds.isEmpty()) {
            Long rowId = Long.valueOf(seatAndRowIds.substring(seatAndRowIds.indexOf("row") + 3, seatAndRowIds.indexOf("seat")));
            Long seatId = Long.valueOf(seatAndRowIds.substring(seatAndRowIds.indexOf("seat")+4));
            final TicketDto ticketDto = new TicketDto();
            ticketDto.setSeatId(seatId);
            ticketDto.setRowId(rowId);
            ticketDto.setProjectionId(projectionId);
            ticketDto.setTheatreId(theatreId);
            tickets.add(ticketDto);
        }
    }

    public void reserveSelectedTickets(ActionEvent actionEvent) {
        reservationService.reserveTickets(tickets, projectionId, theatreId, userId);
        boolean success = reservedTickets.addAll(tickets);
        tickets = new ArrayList<TicketDto>();
        if(success) {
            addMessage("Your tickets have been reserved!","Success");
            return;
        }
        addMessage("We were unable to reserve your tickets!","Failed");
    }

    public String checkSeatForReservation(TheatreSeatDto theatreSeatDto) {
        for(TicketDto ticketDto : reservedTickets) {
            if(theatreSeatDto.getNumber().equals(ticketDto.getSeatId()) &&
                    theatreSeatDto.getRowNumber().equals(ticketDto.getRowId())){
                return "seat-payed";
            }
        }
        return "";
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
        this.reservedTickets = reservationService.getReservationsForProjection(projectionId);
        this.selectedProjection = projectionService.getById(projectionId);
        this.selectedMovie = movieService.getById(this.selectedProjection.getMovieId());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MovieDto getSelectedMovie() {
        return selectedMovie;
    }

    public ProjectionDto getSelectedProjection() {
        return selectedProjection;
    }
}
