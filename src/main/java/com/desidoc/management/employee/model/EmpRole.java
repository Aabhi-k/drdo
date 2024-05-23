package com.desidoc.management.employee.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_role")
public class EmpRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "role_short_name")
	private String roleShortName;
	
	@Column(name = "role_full_name")
	private String roleFullName;
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	
	//	Constructors
	
	public EmpRole() {}

	public EmpRole(Integer id, String roleShortName, String roleFullName, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.roleShortName = roleShortName;
		this.roleFullName = roleFullName;
		this.lastUpdated = lastUpdated;
	}
	
	//	Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleShortName() {
		return roleShortName;
	}

	public void setRoleShortName(String roleShortName) {
		this.roleShortName = roleShortName;
	}

	public String getRoleFullName() {
		return roleFullName;
	}

	public void setRoleFullName(String roleFullName) {
		this.roleFullName = roleFullName;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	

}
