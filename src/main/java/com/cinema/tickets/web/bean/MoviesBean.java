package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;
import com.cinema.tickets.service.MovieService;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

public class MoviesBean {

    private MovieDto movie;
    MovieService movieService;
//    private List<MovieDto> movies;

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public void getDetailedInfo(long id){
        movie = movieService.getDetailedMovieInfo(id);
    }

    public List<MovieDto> getAdditonalMovies() {
        return movieService.moviesForHomePage();
    }

    public List<MovieDto> getAllMoviesOnScreen(){
        return movieService.getAllMoviesOnScreen();
    }
}

