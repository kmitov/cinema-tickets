package com.cinema.tickets.assembler;

import com.cinema.tickets.dto.MovieDto;
import com.cinema.tickets.entity.Movie;

/**
 * Created by kmitov on 1/16/15.
 */
public interface MovieAssembler {

    MovieDto toMovieDto(Movie movie);
}
