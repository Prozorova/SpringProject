package ru.gb.portal.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="advertisement")
@NamedQueries({
	@NamedQuery(name = Advertisement.QUERY_FIND_ALL, query = "SELECT e from Advertisement e"),
	@NamedQuery(name = Advertisement.QUERY_FIND_COMPANY, query = "SELECT e.company from Advertisement e WHERE e.id = :id"),
	@NamedQuery(name = Advertisement.QUERY_FIND_BY_CATEGORY, query = "SELECT e from Advertisement e WHERE e.category = :category")
})
public class Advertisement {
	
	public static final String QUERY_FIND_ALL = "Advertisement.findAll";
	public static final String QUERY_FIND_COMPANY = "Advertisement.findCompany";
	public static final String QUERY_FIND_BY_CATEGORY = "Advertisement.findAllByCategory";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Category category;
	
	@Column(nullable = false)
	private String title;
	
	private String content;
	
	@ManyToOne
	private Company company;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishedDate;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}
	
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}


	public static Advertisement getNewAdvertisement(Category category, String title, String content, Company company) {
		Advertisement advertisement = new Advertisement();
		advertisement.setCategory(category);
		advertisement.setTitle(title);
		advertisement.setContent(content);
		advertisement.setCompany(company);
		advertisement.setPublishedDate(new Date());
		return advertisement;
	}
}
