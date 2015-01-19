package com.cinema.tickets.service;

/**
 * Created by kmitov on 1/19/15.
 */
public interface ProjectionService {

    public com.cinema.tickets.dto.ProjectionDto addProjection(Long movieId, Long theatreId);
}
