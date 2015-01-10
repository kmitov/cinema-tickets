package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.MovieDto;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by soniav on 10.1.2015 г..
 */

@ManagedBean
public class MoviesBean {

    private List<MovieDto> movies;

    public List<MovieDto> getMovies() {
        return movies;
    }
}
