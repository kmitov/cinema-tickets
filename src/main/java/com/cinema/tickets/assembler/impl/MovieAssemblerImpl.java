package com.cinema.tickets.assembler.impl;

import com.cinema.tickets.assembler.MovieAssembler;
import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;

/**
 * Created by kmitov on 1/16/15.
 */
public class MovieAssemblerImpl implements MovieAssembler {
    @Override
    public MovieDto toMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setActors(movie.getActors());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        movieDto.setDirectors(movie.getDirectors());
        movieDto.setDuration(movie.getDuration());
        movieDto.setId(movie.getId());
        movieDto.setImageUrl(movie.getImageUrl());
        movieDto.setRating(movie.getRating());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setGenre(movie.getGenre());
        return movieDto;
    }
}
