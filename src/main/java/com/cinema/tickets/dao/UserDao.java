package com.cinema.tickets.dao;

import com.cinema.tickets.dao.base.BaseDao;
import com.cinema.tickets.entity.User;

/**
 * Created by kmitov on 12/8/14.
 */
public interface UserDao extends BaseDao<User> {

    User getByUsername(String username);

    boolean createUserAccount(User newUser);
}
