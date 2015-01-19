package com.cinema.tickets.dao.impl;

import com.cinema.tickets.dao.TicketDao;
import com.cinema.tickets.dao.base.BaseDaoImpl;
import com.cinema.tickets.entity.Ticket;

import javax.management.Query;

/**
 * Created by kmitov on 1/19/15.
 */
public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao {

    public void deleteTicketsForReservation(long reservationId){
         getSessionFactory().getCurrentSession()
                 .createQuery("delete Ticket where reservationId=:reservationID")
                 .setParameter("reservationID",reservationId).executeUpdate();
    }
}
