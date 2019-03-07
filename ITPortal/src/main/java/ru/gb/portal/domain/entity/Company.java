package ru.gb.portal.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="company")
@NamedQueries({
	@NamedQuery(name = Company.QUERY_FIND_ALL, query = "SELECT e from Company e"),
	@NamedQuery(name = Company.QUERY_FIND, query = "SELECT e from Company e WHERE e.companyName = :companyName")
})
public class Company {
	
	public static final String QUERY_FIND_ALL = "Company.findAll";
	public static final String QUERY_FIND = "Company.find";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private String website;
	
	@Column(nullable = false)
	private String phone;
	
	
	public Company() {
		super();
	}


	public Company(String companyName, String description, String website, String phone) {
		super();
		
		this.companyName = companyName;
		this.description = description;
		this.website = website;
		this.phone = phone;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
}
