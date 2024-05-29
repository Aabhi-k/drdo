package com.desidoc.management.employee.model;

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
@Table(name = "emp_designation")
public class EmpDesignation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "design_short_name", length = 45)
	private String designShortName;

	@Column(name = "design_full_name", length = 200)
	private String designFullName;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cadre_id", referencedColumnName = "cadre_id")
	private EmpCadre cadreId; //foreign key to emp_cadre

	
	
	@Column(name = "order_no", nullable = false) //need to change the ordering system
	private Integer orderNo = -1;
	
	//	Constructors
	
	public EmpDesignation () {}
	
	
	public EmpDesignation(Integer id, String designShortName, String designFullName, EmpCadre cadreId,
			Integer orderNo) {
		super();
		this.id = id;
		this.designShortName = designShortName;
		this.designFullName = designFullName;
		this.cadreId = cadreId;
		this.orderNo = orderNo;
	}

	//	Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignShortName() {
		return designShortName;
	}

	public void setDesignShortName(String designShortName) {
		this.designShortName = designShortName;
	}

	public String getDesignFullName() {
		return designFullName;
	}

	public void setDesignFullName(String designFullName) {
		this.designFullName = designFullName;
	}

	public EmpCadre getCadreId() {
		return cadreId;
	}

	public void setCadreId(EmpCadre cadreId) {
		this.cadreId = cadreId;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	

}
