package com.desidoc.management.others.telephone;

import java.time.LocalDateTime;

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
@Table(name = "useful_tel_no_delhi")
public class UsefulTelNoDelhi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tel_no_entity", length = 200)
	private String telNoEntity;
	
	@Column(name = "tel_no", length = 200)
	private String telNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private TelephoneCategory catId; // foreign key to TelephoneCategory
	
	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;
	
	
	//Constructors
	public UsefulTelNoDelhi() {}

	public UsefulTelNoDelhi(Integer id, String telNoEntity, String telNo, TelephoneCategory catId,
			LocalDateTime lastUpdated) {
		super();
		this.id = id;
		this.telNoEntity = telNoEntity;
		this.telNo = telNo;
		this.catId = catId;
		this.lastUpdated = lastUpdated;
	}

	//GEtters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelNoEntity() {
		return telNoEntity;
	}

	public void setTelNoEntity(String telNoEntity) {
		this.telNoEntity = telNoEntity;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public TelephoneCategory getCatId() {
		return catId;
	}

	public void setCatId(TelephoneCategory catId) {
		this.catId = catId;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
	
	

}
