package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.ProjectionDto;
import com.cinema.tickets.entity.Projection;

/**
 * Created by kmitov on 1/19/15.
 */
public interface ProjectionAssembler {
    Projection toEntity(ProjectionDto dto);

    ProjectionDto toDto(Projection entity);
}
