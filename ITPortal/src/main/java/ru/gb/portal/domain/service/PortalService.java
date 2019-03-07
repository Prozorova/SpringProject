package ru.gb.portal.domain.service;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.entity.Company;
import ru.gb.portal.domain.repository.AdvertisementRepo;
import ru.gb.portal.domain.repository.CategoryRepo;
import ru.gb.portal.domain.repository.CompanyRepo;

@Named
@Scope(WebApplicationContext.SCOPE_APPLICATION)
@Transactional
public class PortalService {
	
	@Autowired
	private AdvertisementRepo advRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private CompanyRepo comRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	

	public void save(Advertisement ad) {
		advRepo.add(ad);
	}

	public void delete(long id) {
		advRepo.remove(advRepo.getByID(id));
	}

	public void update(Advertisement t) {
		advRepo.update(t);
	}

	public void addAll(List<Advertisement> list) {
		for (Advertisement adv : list)
			advRepo.add(adv);
	}
	
	public Advertisement getByID(long id) {
		return ((AdvertisementRepo)advRepo).getByID(id);
	}
	
	public List<Advertisement> getAll() {
		if (advRepo != null)
			return advRepo.getAll();
		else
			return null;
	}
	
	public List<Category> getAllCategories() {
		if (catRepo != null)
			return catRepo.getAll();
		else
			return null;
	}
	
	public List<Company> getAllCompanies() {
		if (comRepo != null)
			return comRepo.getAll();
		else
			return null;
	}
	
	public List<Advertisement> getAllByCategory(long categoryID) {
		return ((AdvertisementRepo)advRepo).getAllByCategory(categoryRepo.getByID(categoryID));
	}
	
	public Company getAllAdvOwner(long id) {
		return ((AdvertisementRepo)advRepo).getCompanyOfAdv(id);
	}
	
	public Category getCategoryByName(String name) {
		return catRepo.getByName(name);
	}
	
	public Company getCompanyByName(String name) {
		return comRepo.getByName(name);
	}

}
