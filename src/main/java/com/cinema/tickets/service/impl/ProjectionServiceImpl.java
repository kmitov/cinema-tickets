package com.cinema.tickets.service.impl;

import com.cinema.tickets.assembler.ProjectionAssembler;
import com.cinema.tickets.dao.ProjectionDao;
import com.cinema.tickets.dto.ProjectionDto;
import com.cinema.tickets.service.ProjectionService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class ProjectionServiceImpl implements ProjectionService {

    private ProjectionDao projectionDao;

    private ProjectionAssembler projectionAssembler;

    @Override
    @Transactional
    public ProjectionDto addProjection(Long movieId, Long theatreId) {
        ProjectionDto projectionDto = new ProjectionDto();
        projectionDto.setDate(new Date(System.currentTimeMillis()));
        projectionDto.setMovieId(movieId);
        projectionDto.setTheatreId(theatreId);
        final ProjectionDto result = projectionAssembler.toDto(
                projectionDao.create(projectionAssembler.toEntity(projectionDto)));
        return result;
    }

    @Override
    @Transactional
    public List<ProjectionDto> getAllProjections() {
        return projectionAssembler.toDtoList(projectionDao.loadAll());
    }

    @Required
    public void setProjectionAssembler(ProjectionAssembler projectionAssembler) {
        this.projectionAssembler = projectionAssembler;
    }

    @Required
    public void setProjectionDao(ProjectionDao projectionDao) {
        this.projectionDao = projectionDao;
    }
}
