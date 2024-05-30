package com.desidoc.management.lab.model;

import java.time.LocalDateTime;

import com.desidoc.management.others.city.StdCodeMaster;

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
@Table(name = "lab_fax_master")
public class LabFaxMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "std_code_id", referencedColumnName = "id")
	private StdCodeMaster stdCodeId; // foreign key to StdCodeMaster

	@Column(name = "fax_no", length = 100)
	private String faxNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_id", referencedColumnName = "id")
	private LabMaster labId; // foreign key to LabMaster

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fax_cat_id", referencedColumnName = "id")
	private LabFaxCategory faxCatId; // foreign key to LabFaxCategory

	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;

	//Constructors
	public LabFaxMaster() {
	}

	public LabFaxMaster(Integer id, StdCodeMaster stdCodeId, String faxNo, LabMaster labId, LabFaxCategory faxCatId,
			LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.stdCodeId = stdCodeId;
		this.faxNo = faxNo;
		this.labId = labId;
		this.faxCatId = faxCatId;
		this.lastUpdated = lastUpdated;
	}
	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StdCodeMaster getStdCodeId() {
		return stdCodeId;
	}

	public void setStdCodeId(StdCodeMaster stdCodeId) {
		this.stdCodeId = stdCodeId;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public LabMaster getLabId() {
		return labId;
	}

	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}

	public LabFaxCategory getFaxCatId() {
		return faxCatId;
	}

	public void setFaxCatId(LabFaxCategory faxCatId) {
		this.faxCatId = faxCatId;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
