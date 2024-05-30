package com.desidoc.management.others.telephone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "telephone_category")
public class TelephoneCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tele_cat_name", length = 200)
	private String teleCatName;
	
	//Constructors
	
    public TelephoneCategory() {}

	public TelephoneCategory(Integer id, String teleCatName) {
		super();
		this.id = id;
		this.teleCatName = teleCatName;
	}
	
	//Getters and Setters


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeleCatName() {
		return teleCatName;
	}

	public void setTeleCatName(String teleCatName) {
		this.teleCatName = teleCatName;
	}
    
	
	
	
}
