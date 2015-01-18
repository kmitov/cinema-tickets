package com.cinema.tickets.service;

import com.cinema.tickets.assembler.UserAssembler;
import com.cinema.tickets.dao.UserDao;
import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.enums.UserRole;

public class UserService {
    UserDao userDao;
    UserAssembler userAssembler;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserAssembler getUserAssembler() {
        return userAssembler;
    }

    public void setUserAssembler(UserAssembler userAssembler) {
        this.userAssembler = userAssembler;
    }

    public void createUserAccount(UserDto newUser){
        newUser.setUserRole(UserRole.ROLE_USER);
        newUser.setEnabled(true);
        userDao.createUserAccount(userAssembler.toEntity(newUser));
    }

    public void createAdminAccount(UserDto newUser){
        newUser.setUserRole(UserRole.ROLE_ADMIN);
        newUser.setEnabled(true);
        userDao.createUserAccount(userAssembler.toEntity(newUser));
    }
}
