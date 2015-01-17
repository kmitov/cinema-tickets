package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.TheatreDto;
import com.cinema.tickets.entity.Theatre;

/**
 * Created by kmitov on 1/16/15.
 */
public interface TheatreAssembler {
    TheatreDto toDto(Theatre theatre);
}
