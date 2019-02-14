package ru.gb.portal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.portal.config.ApplicationConfig;
import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.entity.Company;
import ru.gb.portal.domain.service.AdvertisementService;
import ru.gb.portal.domain.service.CategoryService;
import ru.gb.portal.domain.service.CompanyService;
import ru.gb.portal.domain.entity.Category;

public class DBTest {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		final CompanyService companyService = context.getBean(CompanyService.class);
		final CategoryService categoryService = context.getBean(CategoryService.class);
		final AdvertisementService adService = context.getBean(AdvertisementService.class);
		
		
		final Company comp1 = Company.getNewCompany(
				"Telenor", 
				"It is one of the world's largest mobile telecommunications companies with operations worldwide,", 
				"	35,121 (end 2014)[2]\n" + 
				"www.telenor.com", 
				"888-77-74");
		final Company comp2 = Company.getNewCompany(
				"Ledo Pizza", 
				"Restaurant chain in the Mid-Atlantic and Southeastern United States headquartered in Annapolis, Maryland", 
				"ledopizza.com", 
				"888-64-73");
		final Company comp3 = Company.getNewCompany(
				"DirectBuy", 
				"Members pay a fee, which entitles them to buy products at a discount, directly from the manufacturer and its authorized suppliers", 
				"directbuy.com", 
				"867-57-17");
		
		final Category category1 = Category.getNewCategory("Vacancy");
		final Category category2 = Category.getNewCategory("Selling");
		
		final Advertisement adv1 = Advertisement.getNewAdvertisement(category1, "IT Engineer", "description...", comp1);
		final Advertisement adv2 = Advertisement.getNewAdvertisement(category1, "Project Manager", "description...", comp2);
		final Advertisement adv3 = Advertisement.getNewAdvertisement(category2, "Fitness Equipment", "description...", comp3);
		final Advertisement adv4 = Advertisement.getNewAdvertisement(category1, "Medical Officer", "description...", comp2);
		final Advertisement adv5 = Advertisement.getNewAdvertisement(category2, "Top brands fragrances", "description...", comp3);
		final Advertisement adv6 = Advertisement.getNewAdvertisement(category2, "Subwoofer", "description...", comp3);
		final Advertisement adv7 = Advertisement.getNewAdvertisement(category2, "Pizza", "description...", comp2);
		
		
		final List<Company> companies = new ArrayList<Company>() {{
			add(comp1);
			add(comp2);
			add(comp3);
		}};
		
		final List<Category> categories = new ArrayList<Category>() {{
			add(category1);
			add(category2);
		}};
		
		final List<Advertisement> advertisements = new ArrayList<Advertisement>() {{
			add(adv1);
			add(adv2);
			add(adv3);
			add(adv4);
			add(adv5);
			add(adv6);
			add(adv7);
		}};
		
		
		companyService.addAll(companies);
		categoryService.addAll(categories);
		adService.addAll(advertisements);
		
	}
}
