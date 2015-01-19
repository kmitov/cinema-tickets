package com.cinema.tickets.assembler.impl;

import com.cinema.tickets.assembler.TheatreAssembler;
import com.cinema.tickets.dto.TheatreDto;
import com.cinema.tickets.entity.Theatre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmitov on 1/16/15.
 */
public class TheatreAssemblerImpl implements TheatreAssembler {

    @Override
    public TheatreDto toDto(Theatre entity) {
        final TheatreDto dto = new TheatreDto();
        dto.setId(entity.getId());
        dto.setCapacity(100);
        dto.setName("Grand Hall Sofia");
        return dto;
    }

    @Override
    public Theatre toEntity(TheatreDto dto) {
        final Theatre entity = new Theatre();
        entity.setId(dto.getId());
        entity.setCapacity(dto.getCapacity());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public List<TheatreDto> toDtoList(List<Theatre> entities) {
        final List<TheatreDto> result = new ArrayList<TheatreDto>();
        for(Theatre theatre : entities){
            result.add(toDto(theatre));
        }
        return result;
    }
}
