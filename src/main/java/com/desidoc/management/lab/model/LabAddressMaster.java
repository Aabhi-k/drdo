package com.desidoc.management.lab.model;

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
@Table(name = "lab_address_master")
public class LabAddressMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_id", referencedColumnName = "id")
	private LabMaster labId; //foreign key to LabMaster

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private CityMaster cityId; //foreign key to CityMaster
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id", referencedColumnName = "id")
	private ZipcodeMaster zipcodeId; //foreign key to ZipcodeMaster
	
	@Column(name = "address_line1", length = 200)
	private String addressLine1;
	
	@Column(name = "address_line2", length = 200)
	private String addressLine2;
	
	@Column(name = "address_line3", length = 200)
	private String addresssLine3;
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdted;
	
	//	Constructors
	
	public LabAddressMaster () {}

	
	
	public LabAddressMaster(Integer id, LabMaster labId, String addressLine1, String addressLine2, String addresssLine3,
			CityMaster cityId, ZipcodeMaster zipcodeId, LocalDateTime lastUpdted) {
		super();
		this.id = id;
		this.labId = labId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addresssLine3 = addresssLine3;
		this.cityId = cityId;
		this.zipcodeId = zipcodeId;
		this.lastUpdted = lastUpdted;
	}



	// Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAddresssLine3() {
		return addresssLine3;
	}

	public void setAddresssLine3(String addresssLine3) {
		this.addresssLine3 = addresssLine3;
	}

	public CityMaster getCityId() {
		return cityId;
	}

	public void setCityId(CityMaster cityId) {
		this.cityId = cityId;
	}

	public ZipcodeMaster getZipcodeId() {
		return zipcodeId;
	}

	public void setZipcodeId(ZipcodeMaster zipcodeId) {
		this.zipcodeId = zipcodeId;
	}

	public LocalDateTime getLastUpdted() {
		return lastUpdted;
	}

	public void setLastUpdted(LocalDateTime lastUpdted) {
		this.lastUpdted = lastUpdted;
	}



	public LabMaster getLabId() {
		return labId;
	}



	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}
	
	
	

}
