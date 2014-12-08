package com.cinema.tickets.dao.base;

import java.util.List;

/**
 * Created by kmitov on 12/8/14.
 */
public interface BaseDao<E> {

    E create(E entity);

    List<E> loadAll();

    E get(Long id);

    void update(E entity);

    void merge(E entity);

}
