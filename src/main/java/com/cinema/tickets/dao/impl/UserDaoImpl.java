package com.cinema.tickets.dao.impl;

import com.cinema.tickets.dao.UserDao;
import com.cinema.tickets.dao.base.BaseDaoImpl;
import com.cinema.tickets.entity.User;
import org.hibernate.Query;

/**
 * Created by kmitov on 12/8/14.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User getByUsername(String username) {
        final StringBuilder queryString = new StringBuilder();
        queryString.append("FROM User AS u WHERE u.userName = :username");
        final Query query = getSessionFactory().getCurrentSession().createQuery(queryString.toString());
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

}
