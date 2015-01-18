package com.cinema.tickets.service;

import com.cinema.tickets.assembler.MovieAssembler;
import com.cinema.tickets.dao.MovieDao;
import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    public MovieDao movieDao;
    private MovieAssembler movieAssembler;

    public MovieDao getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public MovieAssembler getMovieAssembler() {
        return movieAssembler;
    }

    public void setMovieAssembler(MovieAssembler movieAssembler) {
        this.movieAssembler = movieAssembler;
    }

    public List<MovieDto> moviesForHomePage(){
        List<MovieDto> moviesForHomepage = new ArrayList<MovieDto>();
        List<Movie> movies = movieDao.getLatestMovies();
        for (Movie movie : movies){
            moviesForHomepage.add(movieAssembler.toMovieDto(movie));
            if(moviesForHomepage.size()==4)
                break;
        }
        return moviesForHomepage;
    }

    public MovieDto getDetailedMovieInfo(long movieID){
        Movie movie = movieDao.getMovie(movieID);
        return movieAssembler.toMovieDto(movie);
    }
}