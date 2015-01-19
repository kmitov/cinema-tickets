package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.ReservationDto;
import com.cinema.tickets.dto.TheatreRowDto;
import com.cinema.tickets.dto.TheatreSeatDto;
import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.entity.Reservation;
import com.cinema.tickets.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kmitov on 1/14/15.
 */
public class TheatreBean {

    private ReservationService reservationService;

    private List<TheatreRowDto> rows;
    private List<TicketDto> reservedTickets;
    private List<TicketDto> tickets;
    private List<ReservationDto> reservationDtos;

    private Long movieId;

    private static final int MAX_SEATS_PER_ROW = 12;

    //TEST DATA
    private static final Long PROJECTION_ID = 1L;
    private static final Long THEATRE_ID = 1L;
    private static final Long USER_ID = 1L;

    //Dummy constructor to produce an example theatre
    public TheatreBean(ReservationService reservationService) {
        this.reservationService = reservationService;
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

        tickets = new ArrayList<TicketDto>();
        reservedTickets = reservationService.getReservationsForProjection(PROJECTION_ID);
    }

    public List<TheatreRowDto> getRows() {
        return rows;
    }

    public void reservePlace() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String seatAndRowIds = params.get("seatId");
        Long rowId = Long.valueOf(seatAndRowIds.substring(seatAndRowIds.indexOf("row") + 3, seatAndRowIds.indexOf("seat")));
        Long seatId = Long.valueOf(seatAndRowIds.substring(seatAndRowIds.indexOf("seat")+4));
        final TicketDto ticketDto = new TicketDto();
        ticketDto.setSeatId(seatId);
        ticketDto.setRowId(rowId);
        ticketDto.setReservationId(1l);
        ticketDto.setProjectionId(1l);
        ticketDto.setTheatreId(1l);
        tickets.add(ticketDto);
    }

    public void reserveSelectedTickets(ActionEvent actionEvent) {
        reservationService.reserveTickets(tickets, PROJECTION_ID, THEATRE_ID, USER_ID);
        reservedTickets.addAll(tickets);
        tickets = new ArrayList<TicketDto>();
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

}
