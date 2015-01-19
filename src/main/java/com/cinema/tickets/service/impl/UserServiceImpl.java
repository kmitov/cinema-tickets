package com.cinema.tickets.service.impl;

import com.cinema.tickets.assembler.UserAssembler;
import com.cinema.tickets.dao.UserDao;
import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.enums.UserRole;
import com.cinema.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserAssembler userAssembler;

    public boolean createUserAccount(UserDto newUser){
        newUser.setUserRole(UserRole.ROLE_USER);
        newUser.setEnabled(true);
        return userDao.createUserAccount(userAssembler.toEntity(newUser));
    }

    public void createAdminAccount(UserDto newUser){
        newUser.setUserRole(UserRole.ROLE_ADMIN);
        newUser.setEnabled(true);
        userDao.createUserAccount(userAssembler.toEntity(newUser));
    }


    @Required
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Required
    public void setUserAssembler(UserAssembler userAssembler) {
        this.userAssembler = userAssembler;
    }

    @Override
    @Transactional
    public UserDto getByUsername(String username) {
        return userAssembler.toDto(userDao.getByUsername(username));
    }
}
