package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.dto.TheatreDto;
import com.cinema.tickets.service.MovieService;
import com.cinema.tickets.service.ProjectionService;
import com.cinema.tickets.service.TheatreService;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class ProjectionsBean {

    private TheatreService theatreService;
    private MovieService movieService;
    private ProjectionService projectionService;

    private List<MovieDto> movies;
    private List<TheatreDto> theatres;

    private Long movieId;
    private Long theatreId;

    public void addProjection(){
        projectionService.addProjection(this.movieId, this.theatreId);
    }

    public ProjectionsBean(MovieService movieService, TheatreService theatreService, ProjectionService projectionService) {
        this.projectionService = projectionService;
        this.movieService = movieService;
        this.theatreService = theatreService;

        this.movies = this.movieService.getAllMoviesOnScreen();
        this.theatres = this.theatreService.getAllTheatres();
    }

    public List<TheatreDto> getTheatres() {
        return theatres;
    }

    public List<MovieDto> getMovies() {
        return movies;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
