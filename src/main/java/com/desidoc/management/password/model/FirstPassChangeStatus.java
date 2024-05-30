package com.desidoc.management.password.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "first_pass_change_status")
public class FirstPassChangeStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "login_id", referencedColumnName = "id")
	private Login loginId; // foreign key to login
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	
	//	Constructors
	public FirstPassChangeStatus() {}

	public FirstPassChangeStatus(Integer id, Login loginId, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.lastUpdated = lastUpdated;
	}
	
	//	Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Login getLoginId() {
		return loginId;
	}

	public void setLoginId(Login loginId) {
		this.loginId = loginId;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
	
	
	
}
