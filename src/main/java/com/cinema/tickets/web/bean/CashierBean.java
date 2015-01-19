package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.dto.ProjectionDto;
import com.cinema.tickets.dto.ReservationDto;
import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.entity.Reservation;
import com.cinema.tickets.service.MovieService;
import com.cinema.tickets.service.ProjectionService;
import com.cinema.tickets.service.ReservationService;
import com.cinema.tickets.service.impl.ProjectionServiceImpl;

import javax.faces.event.ComponentSystemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by Jordan Danchev on 15.1.2015 г..
*/


public class CashierBean {

    private ReservationService reservationService;
    private ProjectionService projectionService;
    private MovieService movieService;

    private List<ReservationXto> reservations;


    public CashierBean(MovieService movieService, ProjectionService projectionService, ReservationService reservationService) {
        this.movieService = movieService;
        this.projectionService = projectionService;
        this.reservationService = reservationService;
    }

    public void refreshOnLoad(ComponentSystemEvent event) {
        refreshReservations();
    }

    private void refreshReservations() {
        final List<ReservationDto> reservationDtos = reservationService.getAllReservations();
        reservations = new ArrayList<ReservationXto>();
        for(ReservationDto reservationDto : reservationDtos) {

            final ProjectionDto projectionDto = this.projectionService.getById(reservationDto.getProjectionId());
            if(projectionDto != null) {
                final MovieDto movieDto = this.movieService.getById(projectionDto.getMovieId());
                final List<TicketDto> tickets = this.reservationService.getReservationsForProjection(projectionDto.getId());
                final ReservationXto xto = new ReservationXto();
                xto.setId(reservationDto.getId());
                xto.setDate(projectionDto.getDate());
                xto.setMovieTitle(movieDto.getTitle());
                xto.setTickets(tickets.size());
                StringBuilder ticketNumbers = new StringBuilder();
                for(TicketDto ticketDto : tickets) {
                    ticketNumbers.append("row: ").append(ticketDto.getRowId())
                            .append("; seat: ").append(ticketDto.getSeatId()).append(";");
                }
                xto.setNumbers(ticketNumbers.toString());
                this.reservations.add(xto);
            }

        }
    }

    public List<ReservationXto> getReservations() {
        return reservations;
    }

    public class ReservationXto {
        private Long id;
        private Date date;
        private String movieTitle;
        private int tickets;
        private String numbers;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }

        public int getTickets() {
            return tickets;
        }

        public void setTickets(int tickets) {
            this.tickets = tickets;
        }

        public String getNumbers() {
            return numbers;
        }

        public void setNumbers(String numbers) {
            this.numbers = numbers;
        }
    }
}
