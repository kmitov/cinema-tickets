package com.cinema.tickets.assembler.impl;

import com.cinema.tickets.assembler.UserAssembler;
import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.entity.User;

/**
 * Created by Shymi on 18.1.2015 г..
 */
public class UserAssemblerImpl implements UserAssembler {
    @Override
    public UserDto toDto(User user) {
        return null;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUsername());
        user.setEnabled(userDto.isEnabled());
        user.setUserRole(userDto.getUserRole());
        return user;
    }
}
