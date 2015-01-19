package com.cinema.tickets.service;

import com.cinema.tickets.dto.MovieDto;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public interface MovieService {

    public List<MovieDto> getAllMoviesOnScreen();

    public MovieDto getDetailedMovieInfo(long movieID);

    public List<MovieDto> moviesForHomePage();

    public MovieDto getById(Long id);
}
