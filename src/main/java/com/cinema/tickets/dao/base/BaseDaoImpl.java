package com.cinema.tickets.dao.base;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

/**
 * Created by kmitov on 12/8/14.
 */
public class BaseDaoImpl<E> implements BaseDao<E> {

    private SessionFactory sessionFactory;

    @Override
    public E create(E entity) {
        final Long id = (Long) sessionFactory.getCurrentSession().save(entity);
        Class<?> entityClass = GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[0];
        return (E) sessionFactory.getCurrentSession().load(entityClass, id);
    }

    @Override
    public List<E> loadAll() {
        Class<?> entityClass = GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[0];
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName());
        return query.list();
    }

    public E get(Long id) {
        Class<?> entityClass = GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[0];
        Query query = sessionFactory.getCurrentSession().createQuery(
                "FROM " + entityClass.getName() + " WHERE id = :id").setParameter("id", id);
        return (E) query.uniqueResult();
    }

    @Override
    public void update(E entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void merge(E entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
