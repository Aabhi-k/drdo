package com.desidoc.management.others.city;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city_master")
public class CityMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "city_short_name")
	private String cityShortName;
	
	@Column(name = "city_full_name")
	private String cityFullName;
	
	//Constructors
	
	public CityMaster() {}

	public CityMaster(Integer id, String cityShortName, String cityFullName) {
		super();
		this.id = id;
		this.cityShortName = cityShortName;
		this.cityFullName = cityFullName;
	}



	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityShortName() {
		return cityShortName;
	}

	public void setCityShortName(String cityShortName) {
		this.cityShortName = cityShortName;
	}

	public String getCityFullName() {
		return cityFullName;
	}

	public void setCityFullName(String cityFullName) {
		this.cityFullName = cityFullName;
	}
	
	

}
