package com.desidoc.management.lab.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_cluster")
public class LabCluster {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cluster_short_name")
	private String clusterShortName;
	
	@Column(name = "cluster_full_name")
	private String clusterFullName;
	
	@Column(name = "deleted")
	private String deleted;
	
	@Column(name = "cluster_category")
	private String clusterCategory;

	
	//Constructors
	public LabCluster() {}
	
	
	public LabCluster(Integer id, String clusterShortName, String clusterFullName, String deleted,
			String clusterCategory) {
		super();
		this.id = id;
		this.clusterShortName = clusterShortName;
		this.clusterFullName = clusterFullName;
		this.deleted = deleted;
		this.clusterCategory = clusterCategory;
	}

	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClusterShortName() {
		return clusterShortName;
	}

	public void setClusterShortName(String clusterShortName) {
		this.clusterShortName = clusterShortName;
	}

	public String getClusterFullName() {
		return clusterFullName;
	}

	public void setClusterFullName(String clusterFullName) {
		this.clusterFullName = clusterFullName;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getClusterCategory() {
		return clusterCategory;
	}

	public void setClusterCategory(String clusterCategory) {
		this.clusterCategory = clusterCategory;
	}
	
	

}
