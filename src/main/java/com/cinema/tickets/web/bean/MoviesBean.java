package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;
import com.cinema.tickets.service.MovieService;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by soniav on 10.1.2015 г..
 */

public class MoviesBean {

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    MovieService movieService;

    private List<MovieDto> movies;

    public List<MovieDto> getMovies() {
        return movieService.moviesForHomePage();
    }


}
