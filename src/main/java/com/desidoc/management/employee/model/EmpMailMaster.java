package com.desidoc.management.employee.model;

import java.time.LocalDateTime;

import com.desidoc.management.others.mail.MailCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_mail_master")
public class EmpMailMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "email")
	private String email;
	
	
	@ManyToOne
	@JoinColumn(name = "mail_cat_id", referencedColumnName = "id")
	private MailCategory mailCatId; //foreign key to mail_category
	
	
	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "id")
	private EmpMaster empId; //foreign key to employee master
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;

	//	Constructors
	
	public EmpMailMaster() {}
	
	public EmpMailMaster(Integer id, String email, MailCategory mailCatId, EmpMaster empId, LocalDateTime lastUpdated) {
		super();
		Id = id;
		this.email = email;
		this.mailCatId = mailCatId;
		this.empId = empId;
		this.lastUpdated = lastUpdated;
	}

	//Getters and Setters
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MailCategory getMailCatId() {
		return mailCatId;
	}

	public void setMailCatId(MailCategory mailCatId) {
		this.mailCatId = mailCatId;
	}

	public EmpMaster getEmpId() {
		return empId;
	}

	public void setEmpId(EmpMaster empId) {
		this.empId = empId;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
	
}
