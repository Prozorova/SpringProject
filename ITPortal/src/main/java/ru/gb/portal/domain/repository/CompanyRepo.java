package ru.gb.portal.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ru.gb.portal.domain.entity.Company;

@Repository
public class CompanyRepo extends AbstractRepository<Company> {

	@Override
	public Company getByID(long id) {
		return entityManager.find(Company.class, id);
	}

	@Override
	public List<Company> getAll() {
		return entityManager.createNamedQuery(Company.QUERY_FIND_ALL,Company.class).getResultList();
	}

}
