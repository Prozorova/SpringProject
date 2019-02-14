package ru.gb.portal.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.portal.domain.entity.Company;
import ru.gb.portal.domain.repository.CompanyRepo;

@Transactional
@Service
public class CompanyService extends AbstractDAO<Company> {
	
	@Autowired
	private CompanyRepo repo;

	@Override
	public void save(Company t) {
		repo.add(t);
	}

	@Override
	public void delete(long id) {
		repo.remove(repo.getByID(id));
	}

	@Override
	public void update(Company t) {
		repo.update(t);
	}

	@Override
	public void addAll(List<Company> list) {
		for (Company company : list)
			repo.add(company);
	}
	
	public Company getByID(long id) {
		return repo.getByID(id);
	}

}
