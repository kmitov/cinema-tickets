package com.cinema.tickets.service.impl;

import com.cinema.tickets.assembler.ReservationAssembler;
import com.cinema.tickets.assembler.TicketAssembler;
import com.cinema.tickets.dao.ReservationDao;
import com.cinema.tickets.dao.TicketDao;
import com.cinema.tickets.dto.ReservationDto;
import com.cinema.tickets.dto.TicketDto;
import com.cinema.tickets.service.ReservationService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class ReservationServiceImpl implements ReservationService {

    private TicketDao ticketDao;
    private ReservationDao reservationDao;

    private TicketAssembler ticketAssembler;
    private ReservationAssembler reservationAssembler;

    @Override
    @Transactional
    public ReservationDto reserveTickets(List<TicketDto> ticketDtos, Long projectionId,
                                         Long theatreId, Long userId) {

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setProjectionId(projectionId);
        reservationDto.setUserId(userId);
        reservationDto.setTheatreId(theatreId);
        reservationDto.setDate(new Date(System.currentTimeMillis()));
        final ReservationDto madeReservation = reservationAssembler.toDto(
                reservationDao.create(reservationAssembler.toEntity(reservationDto)));

        for(TicketDto ticketDto : ticketDtos) {
            ticketDto.setReservationId(madeReservation.getId());
            ticketDao.create(ticketAssembler.toEntity(ticketDto));
        }

        return madeReservation;
    }

    @Override
    @Transactional
    public List<TicketDto> getReservationsForProjection(Long projectionId) {
        return ticketAssembler.toDtoList(reservationDao.getByProjectionId(projectionId));
    }

    @Override
    @Transactional
    public List<ReservationDto> getAllReservations() {
        return reservationAssembler.toDtoList(reservationDao.loadAll());
    }

    @Required
    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Required
    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Required
    public void setTicketAssembler(TicketAssembler ticketAssembler) {
        this.ticketAssembler = ticketAssembler;
    }

    @Required
    public void setReservationAssembler(ReservationAssembler reservationAssembler) {
        this.reservationAssembler = reservationAssembler;
    }

    @Override
    @Transactional
    public void deleteReservation(long reservationId){
        ticketDao.deleteTicketsForReservation(reservationId);
        reservationDao.deleteReservation(reservationId);
    }
}
