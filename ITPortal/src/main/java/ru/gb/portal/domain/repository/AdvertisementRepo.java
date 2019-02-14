package ru.gb.portal.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.entity.Company;

@Repository
public class AdvertisementRepo extends AbstractRepository<Advertisement>{

	@Override
	public Advertisement getByID(long id) {
		return entityManager.find(Advertisement.class, id);
	}

	@Override
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
