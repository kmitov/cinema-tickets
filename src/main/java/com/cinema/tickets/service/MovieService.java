package com.cinema.tickets.service;

import com.cinema.tickets.dao.MovieDao;
import com.cinema.tickets.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public MovieDao getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public MovieDao movieDao;

    public List<Movie> moviesForHomePage(){
        List<Movie> movies = movieDao.getLatestMovies();
        return movies;
    }
}