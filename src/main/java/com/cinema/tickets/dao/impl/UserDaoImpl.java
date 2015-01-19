package com.cinema.tickets.dao.impl;

import com.cinema.tickets.dao.UserDao;
import com.cinema.tickets.dao.base.BaseDaoImpl;
import com.cinema.tickets.entity.User;
import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kmitov on 12/8/14.
 */
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User getByUsername(String username) {
        final StringBuilder queryString = new StringBuilder();
        queryString.append("FROM User AS u WHERE u.userName = :username");
        final Query query = getSessionFactory().getCurrentSession().createQuery(queryString.toString());
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    @Override
    public boolean createUserAccount(User newUser) {
        final StringBuilder queryString = new StringBuilder();
        queryString.append("FROM User AS u WHERE u.userName = :username");
        final Query query = getSessionFactory().getCurrentSession().createQuery(queryString.toString());
        query.setParameter("username", newUser.getUserName());

        if (query.uniqueResult()!= null) {
            return false;
        } else {
            getSessionFactory().getCurrentSession().save(newUser);
            return true;
        }
    }
}
