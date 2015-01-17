package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.TheatreRowDto;
import com.cinema.tickets.dto.TheatreSeatDto;
import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.entity.Reservation;
import com.cinema.tickets.entity.TheatreSeat;

import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kmitov on 1/14/15.
 */
public class TheatreBean {

    private List<TheatreRowDto> rows;
    private List<TicketDto> tickets;

    private Long movieId;

    private static final int MAX_SEATS_PER_ROW = 12;

    //Dummy constructor to produce an example theatre
    public TheatreBean() {
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
    }

    public List<TheatreRowDto> getRows() {
        return rows;
    }

    public void reservePlace() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String seatAndRowIds = params.get("seatId");
        Long rowId = Long.valueOf(seatAndRowIds.substring(seatAndRowIds.indexOf("row") + 3, seatAndRowIds.indexOf("seat")));
        Long seatId = Long.valueOf(seatAndRowIds.indexOf("seat"));
        final TicketDto ticketDto = new TicketDto();
        ticketDto.setId(seatId);
        ticketDto.setRowId(rowId);
        ticketDto.setProjectionId(1l);
        tickets.add(ticketDto);
    }

    public void reserveSeats() {

    }

}
