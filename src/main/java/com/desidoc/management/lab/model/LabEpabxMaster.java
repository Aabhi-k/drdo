package com.desidoc.management.lab.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_epabx_master")
public class LabEpabxMaster {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "epabx")
    private String epabx;
	
	@Column(name = "did_no")
    private String didNo;
	
	@ManyToOne
	@JoinColumn(name = "lab_id", referencedColumnName = "id") 
	private LabMaster labId; // foreign key to labMaster
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdted;
	
	//	Constructors
	
	public LabEpabxMaster () {}

	public LabEpabxMaster(Integer id, String epabx, String didNo, LabMaster labId, LocalDateTime lastUpdted) {
		super();
		this.id = id;
		this.epabx = epabx;
		this.didNo = didNo;
		this.labId = labId;
		this.lastUpdted = lastUpdted;
	}
	
	
	// Getters and Setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEpabx() {
		return epabx;
	}

	public void setEpabx(String epabx) {
		this.epabx = epabx;
	}

	public String getDidNo() {
		return didNo;
	}

	public void setDidNo(String didNo) {
		this.didNo = didNo;
	}

	public LabMaster getLabId() {
		return labId;
	}

	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}

	public LocalDateTime getLastUpdted() {
		return lastUpdted;
	}

	public void setLastUpdted(LocalDateTime lastUpdted) {
		this.lastUpdted = lastUpdted;
	}
	
	
	
	
	

}
