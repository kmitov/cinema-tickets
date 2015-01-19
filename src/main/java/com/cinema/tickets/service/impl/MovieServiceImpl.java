package com.cinema.tickets.service.impl;

import com.cinema.tickets.assembler.MovieAssembler;
import com.cinema.tickets.dao.MovieDao;
import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;
import com.cinema.tickets.service.MovieService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    public MovieDao movieDao;
    private MovieAssembler movieAssembler;

    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public void setMovieAssembler(MovieAssembler movieAssembler) {
        this.movieAssembler = movieAssembler;
    }

    @Override
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

    @Override
    public MovieDto getDetailedMovieInfo(long movieID){
        Movie movie = movieDao.getMovie(movieID);
        return movieAssembler.toMovieDto(movie);
    }

    @Override
    @Transactional
    public List<MovieDto> getAllMoviesOnScreen(){
        List<MovieDto> moviesOnScreen = new ArrayList<MovieDto>();
        List<Movie> movies = movieDao.getLatestMovies();
        for (Movie movie : movies){
            moviesOnScreen.add(movieAssembler.toMovieDto(movie));
        }
        return moviesOnScreen;
    }

}