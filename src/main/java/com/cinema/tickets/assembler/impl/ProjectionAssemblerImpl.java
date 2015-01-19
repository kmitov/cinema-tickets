package com.cinema.tickets.assembler.impl;

import com.cinema.tickets.assembler.ProjectionAssembler;
import com.cinema.tickets.dto.ProjectionDto;
import com.cinema.tickets.entity.Projection;

/**
 * Created by kmitov on 1/19/15.
 */
public class ProjectionAssemblerImpl implements ProjectionAssembler {


    @Override
    public Projection toEntity(ProjectionDto dto) {
        final Projection entity = new Projection();
        entity.setId(dto.getId());
        entity.setTheatreId(dto.getTheatreId());
        entity.setMovieId(dto.getMovieId());
        entity.setDate(dto.getDate());
        return entity;
    }

    @Override
    public ProjectionDto toDto(Projection entity) {
        final ProjectionDto dto = new ProjectionDto();
        dto.setId(entity.getId());
        dto.setTheatreId(entity.getTheatreId());
        dto.setMovieId(entity.getMovieId());
        dto.setDate(entity.getDate());
        return dto;
    }
}
