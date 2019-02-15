package ru.gb.portal.domain.service;

import java.util.List;


public abstract class AbstractDAO<T> {
	
	public abstract void save(final T t);
	public abstract void delete(final long id);
	public abstract void update(final T t);
	public abstract void addAll(final List<T> list);
	
}
