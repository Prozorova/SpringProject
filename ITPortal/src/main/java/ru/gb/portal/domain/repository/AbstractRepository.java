package ru.gb.portal.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


public abstract class AbstractRepository<T> implements JPARepository<T>{

	@PersistenceContext
	protected EntityManager entityManager;
	
	public T getEntity(TypedQuery<T> query) {
		final List<T> result = query.getResultList();
		if (result == null || result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	@Override
	public void add(T t) {
		entityManager.persist(t);
	}

	@Override
	public void remove(T t) {
		entityManager.remove(t);
	}

	@Override
	public void update(T t) {
		entityManager.merge(t);
	}
	
}
