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
       return getSessionFactory().getCurrentSession().createQuery("FROM Movie AS m").list();
    }
}
