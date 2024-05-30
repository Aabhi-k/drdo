package com.desidoc.management.others.city;

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
@Table(name = "zipcode_master")
public class ZipcodeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "zipcode", length = 10)
	private String zipcode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private CityMaster cityId; // foreign key to CityMaster

	
	//	Constructors
	public ZipcodeMaster() {}
	
	public ZipcodeMaster(Integer id, String zipcode, CityMaster cityId) {
		super();
		this.id = id;
		this.zipcode = zipcode;
		this.cityId = cityId;
	}

	//Getters and Setters
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public CityMaster getCity_id() {
		return cityId;
	}

	public void setCity_id(CityMaster cityId) {
		this.cityId = cityId;
	}
	
	
	
	
	
}
