package com.cinema.tickets.service;

import com.cinema.tickets.dto.ReservationDto;
import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.entity.Reservation;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public interface ReservationService {

    ReservationDto reserveTickets(List<TicketDto> ticketDtos, Long projectionId, Long theatreId, Long userId);

    List<TicketDto> getReservationsForProjection(Long projectionId);

    List<ReservationDto> getAllReservations();

    void deleteReservation(long reservationId);
}
