package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.TheatreDto;
import com.cinema.tickets.entity.Theatre;

import java.util.List;

/**
 * Created by kmitov on 1/16/15.
 */
public interface TheatreAssembler {
    TheatreDto toDto(Theatre entity);

    Theatre toEntity(TheatreDto dto);

    List<TheatreDto> toDtoList(List<Theatre> entities);
}
