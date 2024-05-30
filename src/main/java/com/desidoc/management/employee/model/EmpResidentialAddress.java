package com.desidoc.management.employee.model;

import java.time.LocalDateTime;

import com.desidoc.management.others.city.CityMaster;
import com.desidoc.management.others.city.ZipcodeMaster;

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
@Table(name = "emp_residential_address")
public class EmpResidentialAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id", referencedColumnName = "id")
	private ZipcodeMaster zipcodeId; // foreign key to zipcodeMaster
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private CityMaster cityId; // Foreign key to CityMaster

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", referencedColumnName = "id")
	private EmpMaster empId; // foreign key to empMaster

	@Column(name = "address_line1" , length = 200)
	private String addressLine1;

	@Column(name = "address_line2", length = 200)
	private String addressLine2;

	@Column(name = "address_line3", length = 200)
	private String addressLine3;

	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;

	// Constructors
	public EmpResidentialAddress() {
	}

	public EmpResidentialAddress(Integer id, ZipcodeMaster zipcodeId, EmpMaster empId, String addressLine1,
			String addressLine2, String addressLine3, CityMaster cityId, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.zipcodeId = zipcodeId;
		this.empId = empId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.cityId = cityId;
		this.lastUpdated = lastUpdated;
	}

	// getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ZipcodeMaster getZipcodeId() {
		return zipcodeId;
	}

	public void setZipcodeId(ZipcodeMaster zipcodeId) {
		this.zipcodeId = zipcodeId;
	}

	public EmpMaster getEmpId() {
		return empId;
	}

	public void setEmpId(EmpMaster empId) {
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

	public CityMaster getCityId() {
		return cityId;
	}

	public void setCityId(CityMaster cityId) {
		this.cityId = cityId;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
