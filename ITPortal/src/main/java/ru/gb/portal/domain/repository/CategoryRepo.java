package ru.gb.portal.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ru.gb.portal.domain.entity.Category;

@Repository
public class CategoryRepo extends AbstractRepository<Category>{

	@Override
	public Category getByID(long id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> getAll() {
		return entityManager.createNamedQuery(Category.QUERY_FIND_ALL,Category.class).getResultList();
	}

}
