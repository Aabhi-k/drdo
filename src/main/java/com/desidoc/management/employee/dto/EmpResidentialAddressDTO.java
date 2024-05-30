package com.desidoc.management.employee.dto;

import java.time.LocalDateTime;

public class EmpResidentialAddressDTO {
	
	private Integer id;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private Integer zipcodeId;
	private Integer empId;
	private Integer cityId;
	private LocalDateTime lastUpdated;
	
	
	// Getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getZipcodeId() {
		return zipcodeId;
	}
	public void setZipcodeId(Integer zipcodeId) {
		this.zipcodeId = zipcodeId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

}
