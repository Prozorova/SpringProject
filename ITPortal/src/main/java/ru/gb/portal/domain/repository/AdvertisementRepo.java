package ru.gb.portal.domain.repository;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.entity.Company;

@Repository
public class AdvertisementRepo {

	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public Advertisement getEntity(TypedQuery<Advertisement> query) {
		final List<Advertisement> result = query.getResultList();
		if (result == null || result.isEmpty())
			return null;
		else
			return result.get(0);
	}

	public void add(Advertisement ad) {
		entityManager.persist(ad);
	}

	public void remove(Advertisement ad) {
		entityManager.remove(ad);
	}

	public void update(Advertisement ad) {
		entityManager.merge(ad);
	}
	
	public Advertisement getByID(long id) {
		return entityManager.find(Advertisement.class, id);
	}

	public List<Advertisement> getAll() {
		return entityManager
				.createNamedQuery(Advertisement.QUERY_FIND_ALL, Advertisement.class)
				.getResultList();
	}
	
	public List<Advertisement> getAllByCategory(Category category) {
		return entityManager
				.createNamedQuery(Advertisement.QUERY_FIND_BY_CATEGORY, Advertisement.class)
				.setParameter("category", category)
				.getResultList();
	}
	
	public Company getCompanyOfAdv(long id) {
		return entityManager
				.createNamedQuery(Advertisement.QUERY_FIND_COMPANY, Company.class)
				.setParameter("id", id)
				.getSingleResult();
	}


}
