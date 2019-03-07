package ru.gb.portal.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.entity.Company;

@Repository
public class CompanyRepo  {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Company getEntity(TypedQuery<Company> query) {
		final List<Company> result = query.getResultList();
		if (result == null || result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	public void add(Company company) {
		entityManager.persist(company);
	}

	public void remove(Company company) {
		entityManager.remove(company);
	}

	public void update(Company company) {
		entityManager.merge(company);
	}

	public Company getByID(long id) {
		return entityManager.find(Company.class, id);
	}
	
	public Company getByName(String name) {
		return entityManager.createNamedQuery(Company.QUERY_FIND, Company.class)
							.setParameter("companyName", name)
							.getSingleResult();
	}

	public List<Company> getAll() {
		return entityManager.createNamedQuery(Company.QUERY_FIND_ALL,Company.class).getResultList();
	}

}
