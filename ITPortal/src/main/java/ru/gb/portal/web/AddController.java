package ru.gb.portal.web;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.entity.Category;
import ru.gb.portal.domain.entity.Company;
import ru.gb.portal.domain.service.PortalService;

@Named
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AddController implements Serializable{

	private static final long serialVersionUID = -5520779612106858150L;
    
    @Autowired
    private PortalService service;
    
    private List<Category> categories;
    private List<Company> companies;
    
    private String title;
    private String category;
    private String companyName;
	private String content;
	
	
	@PostConstruct
    public void init() {
		categories = service.getAllCategories();
		companies = service.getAllCompanies();
    }
	
	public void saveAd() {
		if (title != null && !title.isEmpty() &&
			category != null && !category.isEmpty() &&
			companyName != null && !companyName.isEmpty() &&
			content != null && !content.isEmpty()) {
			
			service.save(new Advertisement(
					service.getCategoryByName(category), 
					title, 
					content, 
					service.getCompanyByName(companyName)
			));
		}
		
		title = null;
		category = null;
		companyName = null;
		content = null;
	}
	

	public List<String> getCategories() {
		return categories.stream().map(Category::getName).collect(Collectors.toList());
	}

	public List<String> getCompanies() {
		return companies.stream().map(Company::getCompanyName).collect(Collectors.toList());
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
