package com.desidoc.management.employee.model;

import java.time.LocalDateTime;

import com.desidoc.management.others.telephone.TelephoneCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_telephone_master")
public class EmpTelephoneMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "id" )
	private EmpMaster empId; //foreign key to emp_master
	
	@ManyToOne
	@JoinColumn(name = "tele_cat_id")
	private TelephoneCategory teleCatId; //foreign key to telephoneCategory
	
	@Column(name = "telephone_number")
	private String telephoneNumber;
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	@Column(name = "epabx")
	private String epabx;
	
	// Constructors
	
	public EmpTelephoneMaster() {}

	public EmpTelephoneMaster(Integer id, EmpMaster empId, TelephoneCategory teleCatId, String telephoneNumber,
			LocalDateTime lastUpdated, String epabx) {
		super();
		this.id = id;
		this.empId = empId;
		this.teleCatId = teleCatId;
		this.telephoneNumber = telephoneNumber;
		this.lastUpdated = lastUpdated;
		this.epabx = epabx;
	}

	//	Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmpMaster getEmpId() {
		return empId;
	}

	public void setEmpId(EmpMaster empId) {
		this.empId = empId;
	}

	public TelephoneCategory getTeleCatId() {
		return teleCatId;
	}

	public void setTeleCatId(TelephoneCategory teleCatId) {
		this.teleCatId = teleCatId;
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

	public String getEpabx() {
		return epabx;
	}

	public void setEpabx(String epabx) {
		this.epabx = epabx;
	}
	
	
	
	
	

}
