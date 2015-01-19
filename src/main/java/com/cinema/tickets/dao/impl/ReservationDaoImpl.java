package com.cinema.tickets.dao.impl;

import com.cinema.tickets.dao.ReservationDao;
import com.cinema.tickets.dao.base.BaseDaoImpl;
import com.cinema.tickets.entity.Reservation;
import com.cinema.tickets.entity.Ticket;
import com.cinema.tickets.entity.User;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class ReservationDaoImpl extends BaseDaoImpl<Reservation> implements ReservationDao {

    @Override
    public List<Ticket> getByProjectionId(Long projectionId) {
        final StringBuilder queryString = new StringBuilder();
        queryString.append("FROM Ticket AS t WHERE t.projectionId = :projectionId");
        final Query query = getSessionFactory().getCurrentSession().createQuery(queryString.toString());
        query.setParameter("projectionId", projectionId);
        return query.list();
    }

    public void deleteReservation(long reservationID){
        getSessionFactory().getCurrentSession()
                .createQuery("delete Reservation where id=:reservationID")
                .setParameter("reservationID",reservationID).executeUpdate();
    }
}
