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
@Table(name="category")
@NamedQueries({
	@NamedQuery(name = Category.QUERY_FIND_ALL, query = "SELECT e from Category e")
})
public class Category {
	
	public static final String QUERY_FIND_ALL = "Category.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Category getNewCategory(String name) {
		Category category = new Category();
		category.setName(name);
		return category;
	}
}
