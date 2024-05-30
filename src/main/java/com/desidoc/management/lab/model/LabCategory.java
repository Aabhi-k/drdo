package com.desidoc.management.lab.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_category")
public class LabCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cat_short_name", length = 45)
	private String catShortName;
	
	@Column(name = "cat_full_name", length = 200)
	private String catFullName;

	//Constructors
	
	public LabCategory() {}
	
	public LabCategory(Integer id, String catShortName, String catFullName) {
		super();
		this.id = id;
		this.catShortName = catShortName;
		this.catFullName = catFullName;
	}

	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatShortName() {
		return catShortName;
	}

	public void setCatShortName(String catShortName) {
		this.catShortName = catShortName;
	}

	public String getCatFullName() {
		return catFullName;
	}

	public void setCatFullName(String catFullName) {
		this.catFullName = catFullName;
	}
	
	
	

}
