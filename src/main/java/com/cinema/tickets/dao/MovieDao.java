package com.cinema.tickets.dao;

import com.cinema.tickets.dao.base.BaseDao;
import com.cinema.tickets.entity.Movie;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by soniav on 17.1.2015 г..
 */
@Transactional
public interface MovieDao extends BaseDao<Movie>{

    List<Movie> getLatestMovies();

    List<Movie> getAllMoviesOnScreen();

    Movie getMovie(long id);

    Movie getByProjectionId(Long id);
}
