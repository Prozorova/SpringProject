package ru.gb.portal.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.entity.Company;
import ru.gb.portal.domain.repository.AdvertisementRepo;
import ru.gb.portal.domain.repository.CategoryRepo;

@Transactional
@Service
public class AdvertisementService extends AbstractDAO<Advertisement>{
	
	@Autowired
	private AdvertisementRepo repo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	

	@Override
	public void save(Advertisement t) {
		repo.add(t);
	}

	@Override
	public void delete(long id) {
		repo.remove(repo.getByID(id));
	}

	@Override
	public void update(Advertisement t) {
		repo.update(t);
	}

	@Override
	public void addAll(List<Advertisement> list) {
		for (Advertisement adv : list)
			repo.add(adv);
	}
	
	public Advertisement getByID(long id) {
		return repo.getByID(id);
	}
	
	public List<Advertisement> getAll() {
		return repo.getAll();
	}
	
	public List<Advertisement> getAllByCategory(long categoryID) {
		return repo.getAllByCategory(categoryRepo.getByID(categoryID));
	}
	
	public Company getAllAdvOwner(long id) {
		return repo.getCompanyOfAdv(id);
	}

}
