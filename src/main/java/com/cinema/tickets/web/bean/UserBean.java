package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.service.UserService;
import com.sun.java.util.jar.pack.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class UserBean {

    UserService userService;
    UserDto userDto;

    public void createAccount(){
        userService.createUserAccount(this.userDto);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
