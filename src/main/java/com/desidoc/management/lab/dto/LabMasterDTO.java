package com.desidoc.management.lab.dto;

import java.time.LocalDateTime;

public class LabMasterDTO {
	private Integer id;
    private String labAuthName;
    private String labShortName;
    private String labFullName;
    private Integer labCatId; // foreign key of the LabCategory
    private Integer labCityId; // foreign key of the CityMaster
    private Integer labClusterId; // foreign key of the LabCluster
    private String otherGroup;
    private LocalDateTime lastUpdated;
    private String deleted;
    private Integer viewingOrder;
    
    
    // Getters and Setters
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
	public Integer getLabCatId() {
		return labCatId;
	}
	public void setLabCatId(Integer labCatId) {
		this.labCatId = labCatId;
	}
	public Integer getLabCityId() {
		return labCityId;
	}
	public void setLabCityId(Integer labCityId) {
		this.labCityId = labCityId;
	}
	public Integer getLabClusterId() {
		return labClusterId;
	}
	public void setLabClusterId(Integer labClusterId) {
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
