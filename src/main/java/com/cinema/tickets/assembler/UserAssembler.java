package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.TheatreDto;
import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.entity.Theatre;
import com.cinema.tickets.entity.User;

public interface UserAssembler {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
