package com.desidoc.management.others.mail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail_category")
public class MailCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "mail_cat_name")
	private String mailCatName;
	
	
	// Constructors
	public MailCategory() {}
	

	public MailCategory(Integer id, String mailCatName) {
		super();
		this.id = id;
		this.mailCatName = mailCatName;
	}


	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMailCatName() {
		return mailCatName;
	}

	public void setMailCatName(String mailCatName) {
		this.mailCatName = mailCatName;
	}
	
	

}
