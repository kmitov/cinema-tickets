package com.cinema.tickets.service;

import com.cinema.tickets.dto.UserDto;

/**
 * Created by kmitov on 1/19/15.
 */
public interface UserService {

    UserDto getByUsername(String username);

    boolean createUserAccount(UserDto newUser);

    void createAdminAccount(UserDto newUser);
}
