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
	
	@Column
	private String content;
	
	@ManyToOne
	private Company company;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date publishedDate;
	

	public Advertisement() {
		super();
	}
	

	public Advertisement(Category category, String title, String content, Company company) {
		super();
		
		this.category = category;
		this.title = title;
		this.content = content;
		this.company = company;
		this.publishedDate = new Date();
	}
	
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
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Advertisement other = (Advertisement) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
