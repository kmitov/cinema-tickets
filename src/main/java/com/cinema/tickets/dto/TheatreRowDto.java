package com.cinema.tickets.dto;

import java.util.List;

/**
 * Created by kmitov on 1/14/15.
 */
public class TheatreRowDto {
    private Long theatreId;
    private Long number;
    private List<TheatreSeatDto> seats;

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<TheatreSeatDto> getSeats() {
        return seats;
    }

    public void setSeats(List<TheatreSeatDto> seats) {
        this.seats = seats;
    }
}
