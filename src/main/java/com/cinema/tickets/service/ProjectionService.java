package com.cinema.tickets.service;

import com.cinema.tickets.dto.ProjectionDto;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public interface ProjectionService {

    ProjectionDto addProjection(Long movieId, Long theatreId);

    List<ProjectionDto> getAllProjections();

    ProjectionDto getById(Long id);
}
