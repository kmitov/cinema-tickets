package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.dto.ProjectionDto;
import com.cinema.tickets.service.MovieService;
import com.cinema.tickets.service.ProjectionService;

import javax.faces.event.ComponentSystemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class ProgrammeBean {

    private ProjectionService projectionService;
    private MovieService movieService;

    private List<ProgrammeDto> movieProjections;


    public List<ProgrammeDto> getMovieProjections() {
        return movieProjections;
    }

    public ProgrammeBean(MovieService movieService, ProjectionService projectionService) {
        this.movieService = movieService;
        this.projectionService = projectionService;
        refreshData();

    }

    private void refreshData() {
        this.movieProjections = new ArrayList<ProgrammeDto>();
        final List<ProjectionDto> projectionDtos = projectionService.getAllProjections();
        for(ProjectionDto projectionDto : projectionDtos) {
            final MovieDto movie = movieService.getDetailedMovieInfo(projectionDto.getMovieId());
            final ProgrammeDto programmeDto = new ProgrammeDto();
            programmeDto.setMovieId(movie.getId());
            programmeDto.setDate(projectionDto.getDate());
            programmeDto.setDuration(movie.getDuration());
            programmeDto.setMovieTitle(movie.getTitle());
            programmeDto.setProjectionId(projectionDto.getId());
            programmeDto.setTheatreId(projectionDto.getTheatreId());
            movieProjections.add(programmeDto);
        }
    }

    public void refreshOnLoad(ComponentSystemEvent event) {
        refreshData();
    }

    public class ProgrammeDto{
        private int duration;
        private String movieTitle;
        private Date date;
        private Long movieId;
        private Long projectionId;
        private Long theatreId;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Long getMovieId() {
            return movieId;
        }

        public void setMovieId(Long movieId) {
            this.movieId = movieId;
        }

        public Long getProjectionId() {
            return projectionId;
        }

        public void setProjectionId(Long projectionId) {
            this.projectionId = projectionId;
        }

        public Long getTheatreId() {
            return theatreId;
        }

        public void setTheatreId(Long theatreId) {
            this.theatreId = theatreId;
        }
    }


}
