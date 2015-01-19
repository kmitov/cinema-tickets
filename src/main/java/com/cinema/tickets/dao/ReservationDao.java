package com.cinema.tickets.dao;

import com.cinema.tickets.dao.base.BaseDao;
import com.cinema.tickets.entity.Reservation;
import com.cinema.tickets.entity.Ticket;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public interface ReservationDao extends BaseDao<Reservation> {

    public List<Ticket> getByProjectionId(Long projectionId);

    void deleteReservation(long reservationID);
}
