package ru.gb.portal.domain.repository;

import java.util.List;

public interface JPARepository<T> {
	
	void add(T t);
	void remove(T t);
	T getByID(long id);
	void update(T t);
	List<T> getAll();
	
}
