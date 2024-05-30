package com.desidoc.management.password.model;

import java.time.LocalDateTime;

import com.desidoc.management.lab.model.LabMaster;

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
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username", length = 45)
	private String username;
	
	@Column(name = "password", length = 256)
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_id", referencedColumnName = "id")
	private LabMaster labId; // foreign key to LabMaster
	
	@Column(name = "active", length = 1)
	private String active;
	
	@Column(name = "date_of_entry")
	private LocalDateTime dateOfEntry;
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	//	Constructors
	public Login() {}

	public Login(Integer id, String username, String password, LabMaster labId, String active,
			LocalDateTime dateOfEntry, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.labId = labId;
		this.active = active;
		this.dateOfEntry = dateOfEntry;
		this.lastUpdated = lastUpdated;
	}
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LabMaster getLabId() {
		return labId;
	}

	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public LocalDateTime getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(LocalDateTime dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
	

}
