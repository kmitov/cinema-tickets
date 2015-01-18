package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.service.UserService;

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
