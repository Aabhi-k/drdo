package com.desidoc.management.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_assigned_role")
public class UserAssignedRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Login login;
	
	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private UserRole roleId;

	
	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Login getUserId() {
		return login;
	}

	public void setUserId(Login userId) {
		this.login = userId;
	}

	public UserRole getRoleId() {
		return roleId;
	}

	public void setRoleId(UserRole roleId) {
		this.roleId = roleId;
	}
	
	

}
