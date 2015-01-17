package com.cinema.tickets.dao.impl;

import com.cinema.tickets.dao.UserDao;
import com.cinema.tickets.dao.base.BaseDaoImpl;
import com.cinema.tickets.entity.User;
import com.cinema.tickets.enums.UserRole;
import org.hibernate.Query;
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
    public void createUserAccount(String userName, String password, String firstName, String lastName) {
        User newUserAccount = new User();
        newUserAccount.setName(userName);
        newUserAccount.setPassword(password);
        newUserAccount.setUserName(firstName + " " + lastName);
        newUserAccount.setUserRole(UserRole.ROLE_USER);
        newUserAccount.setEnabled(false);

        getSessionFactory().getCurrentSession().save(newUserAccount);
    }
}
