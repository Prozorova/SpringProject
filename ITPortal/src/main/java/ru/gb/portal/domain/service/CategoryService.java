package ru.gb.portal.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.repository.CategoryRepo;

@Transactional
@Service
public class CategoryService extends AbstractDAO<Category>{
	
	@Autowired
	private CategoryRepo repo;

	@Override
	public void save(Category t) {
		repo.add(t);
	}

	@Override
	public void delete(long id) {
		repo.remove(repo.getByID(id));
	}

	@Override
	public void update(Category t) {
		repo.update(t);
	}

	@Override
	public void addAll(List<Category> list) {
		for (Category category : list)
			repo.add(category);
	}
	
	public List<Category> getCategories() {
		return repo.getAll();
	}

}
