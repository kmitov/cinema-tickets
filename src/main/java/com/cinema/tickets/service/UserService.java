package com.cinema.tickets.service;

import com.cinema.tickets.dao.UserDao;

public class UserService {
    UserDao userDao;
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUserAccount(String userName,String userPassword, String firstName, String lastName){
        userDao.createUserAccount(userName,userPassword,firstName,lastName);
    }
}
