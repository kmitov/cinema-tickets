package com.cinema.tickets.dao.impl;

import com.cinema.tickets.dao.MovieDao;
import com.cinema.tickets.dao.base.BaseDaoImpl;
import com.cinema.tickets.entity.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soniav on 17.1.2015 г..
 */
public class MovieDaoImpl extends BaseDaoImpl<Movie> implements MovieDao {

    @Override
    public List<Movie> getLatestMovies() {
        return getSessionFactory().getCurrentSession().createQuery("FROM Movie AS m order by m.releaseDate desc").list();
    }

    @Override
    public List<Movie> getAllMoviesOnScreen() {
        return getSessionFactory().getCurrentSession().createQuery("FROM Movie AS m").list();
    }

    @Override
    public Movie getMovie(long id) {
        Object movie = getSessionFactory().getCurrentSession().createQuery("FROM Movie AS m WHERE m.id = :id")
                .setParameter("id", id).uniqueResult();

        return movie != null ? (Movie)movie : null;
    }

    @Override
    public Movie getByProjectionId(Long id) {
        return (Movie) getSessionFactory().getCurrentSession().createSQLQuery(
                "SELECT id, actors, desription, directors, duration, genre, imageUrl, language, rating, releaseDate, title" +
                        "    FROM movies " +
                        "       INNER JOIN projections WHERE movies.id = projections.movieId " +
                        "    WHERE projections.id= :projectionId " +
                        "    LIMIT 1 ").addEntity(Movie.class)
                .setParameter("projectionId", id).uniqueResult();
    }
}
