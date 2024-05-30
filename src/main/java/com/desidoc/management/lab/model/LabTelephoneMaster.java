package com.desidoc.management.lab.model;

import java.time.LocalDateTime;

import com.desidoc.management.others.city.StdCodeMaster;
import com.desidoc.management.others.telephone.TelephoneCategory;

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
@Table(name = "lab_telephone_master")
public class LabTelephoneMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_id", referencedColumnName = "id")
	private LabMaster labId; //foreign key to labMaster
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tele_cat_id", referencedColumnName = "id")
	private TelephoneCategory teleCatId; //foreign key to telephoneCategory
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "std_code_id", referencedColumnName = "id")
	private StdCodeMaster stdCodeId; //foreign key to stdCodeMaster
	
	@Column(name = "telephone_number", length = 45)
	private String telephoneNumber;
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	
	//constructors
	public LabTelephoneMaster() {}


	public LabTelephoneMaster(Integer id, LabMaster labId, TelephoneCategory teleCatId, StdCodeMaster stdCodeId,
			String telephoneNumber, LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.labId = labId;
		this.teleCatId = teleCatId;
		this.stdCodeId = stdCodeId;
		this.telephoneNumber = telephoneNumber;
		this.lastUpdated = lastUpdated;
	}
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LabMaster getLabId() {
		return labId;
	}


	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}


	public TelephoneCategory getTeleCatId() {
		return teleCatId;
	}


	public void setTeleCatId(TelephoneCategory teleCatId) {
		this.teleCatId = teleCatId;
	}


	public StdCodeMaster getStdCodeId() {
		return stdCodeId;
	}


	public void setStdCodeId(StdCodeMaster stdCodeId) {
		this.stdCodeId = stdCodeId;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}


	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}


	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
	
	
	
	
	
	
	

}
