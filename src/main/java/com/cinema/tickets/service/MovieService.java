package com.cinema.tickets.service;

import com.cinema.tickets.dao.MovieDao;
import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    public MovieDao movieDao;

    public MovieDao getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<MovieDto> moviesForHomePage(){
        List<MovieDto> moviesForHomepage = new ArrayList<MovieDto>();
        List<Movie> movies = movieDao.getLatestMovies();
        for (Movie movie : movies){
            moviesForHomepage.add(new MovieDto(movie));
        }
        return moviesForHomepage;
    }
}