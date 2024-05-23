package com.desidoc.management.lab.model;

import java.time.LocalDateTime;

import com.desidoc.management.others.city.CityMaster;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_master")
public class LabMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "lab_auth_name", nullable = false, length = 200)
	private String labAuthName;

	@Column(name = "lab_short_name", nullable = false, length = 45)
	private String labShortName;

	@Column(name = "lab_full_name", nullable = false, length = 200)
	private String labFullName;

	@ManyToOne
	@JoinColumn(name = "lab_cat_id", referencedColumnName = "id")
	private LabCategory labCatId; // foreign key to LabCategory

	@ManyToOne
	@JoinColumn(name = "lab_city_id", referencedColumnName = "id")
	private CityMaster labCityId; // foreign key to CityMaster

	@ManyToOne
	@JoinColumn(name = "lab_cluster_id", nullable = false)
	private LabCluster labClusterId; // foreign key to Lab Cluster

	@Column(name = "other_group", length = 45)
	private String otherGroup;

	@Column(name = "last_updated", nullable = false)
	private LocalDateTime lastUpdated;

	@Column(name = "deleted", nullable = false, length = 1)
	private String deleted;

	@Column(name = "viewing_order", nullable = false)
	private Integer viewingOrder;

	// Constructor
	public LabMaster() {
	}

	public LabMaster(Integer id, String labAuthName, String labShortName, String labFullName, LabCategory labCatId,
			CityMaster labCityId, LabCluster labClusterId, String otherGroup, LocalDateTime lastUpdated, String deleted,
			Integer viewingOrder) {
		super();
		this.id = id;
		this.labAuthName = labAuthName;
		this.labShortName = labShortName;
		this.labFullName = labFullName;
		this.labCatId = labCatId;
		this.labCityId = labCityId;
		this.labClusterId = labClusterId;
		this.otherGroup = otherGroup;
		this.lastUpdated = lastUpdated;
		this.deleted = deleted;
		this.viewingOrder = viewingOrder;
	}

	// Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabAuthName() {
		return labAuthName;
	}

	public void setLabAuthName(String labAuthName) {
		this.labAuthName = labAuthName;
	}

	public String getLabShortName() {
		return labShortName;
	}

	public void setLabShortName(String labShortName) {
		this.labShortName = labShortName;
	}

	public String getLabFullName() {
		return labFullName;
	}

	public void setLabFullName(String labFullName) {
		this.labFullName = labFullName;
	}

	public LabCategory getLabCatId() {
		return labCatId;
	}

	public void setLabCatId(LabCategory labCatId) {
		this.labCatId = labCatId;
	}

	public CityMaster getLabCityId() {
		return labCityId;
	}

	public void setLabCityId(CityMaster labCityId) {
		this.labCityId = labCityId;
	}

	public LabCluster getLabClusterId() {
		return labClusterId;
	}

	public void setLabClusterId(LabCluster labClusterId) {
		this.labClusterId = labClusterId;
	}

	public String getOtherGroup() {
		return otherGroup;
	}

	public void setOtherGroup(String otherGroup) {
		this.otherGroup = otherGroup;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Integer getViewingOrder() {
		return viewingOrder;
	}

	public void setViewingOrder(Integer viewingOrder) {
		this.viewingOrder = viewingOrder;
	}

}
