package ru.gb.portal.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.entity.Company;

@Repository
public class CategoryRepo {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Category getEntity(TypedQuery<Category> query) {
		final List<Category> result = query.getResultList();
		if (result == null || result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	public void add(Category category) {
		entityManager.persist(category);
	}

	public void remove(Category category) {
		entityManager.remove(category);
	}

	public void update(Category category) {
		entityManager.merge(category);
	}

	public Category getByID(long id) {
		return entityManager.find(Category.class, id);
	}
	
	public Category getByName(String name) {
		return entityManager.createNamedQuery(Category.QUERY_FIND, Category.class)
							.setParameter("name", name)
							.getSingleResult();
	}

	public List<Category> getAll() {
		return entityManager.createNamedQuery(Category.QUERY_FIND_ALL,Category.class).getResultList();
	}
}
