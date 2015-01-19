package com.cinema.tickets.service.impl;

import com.cinema.tickets.assembler.TheatreAssembler;
import com.cinema.tickets.dao.TheatreDao;
import com.cinema.tickets.dto.TheatreDto;
import com.cinema.tickets.service.TheatreService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kmitov on 1/19/15.
 */
public class TheatreServiceImpl implements TheatreService {

    private TheatreDao theatreDao;

    private TheatreAssembler theatreAssembler;

    @Override
    @Transactional
    public List<TheatreDto> getAllTheatres() {
        return theatreAssembler.toDtoList(theatreDao.loadAll());
    }

    @Required
    public void setTheatreDao(TheatreDao theatreDao) {
        this.theatreDao = theatreDao;
    }

    @Required
    public void setTheatreAssembler(TheatreAssembler theatreAssembler) {
        this.theatreAssembler = theatreAssembler;
    }
}
