package com.desidoc.management.employee.model;

import java.time.LocalDateTime;

import com.desidoc.management.lab.model.LabMaster;

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
@Table(name = "emp_master")
public class EmpMaster {

	//Structure of emp_master
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;



    @Column(name = "emp_title", length = 45)
    private String empTitle;

    @Column(name = "emp_first_name", length = 200)
    private String empFirstName;

    @Column(name = "emp_middle_name", length = 200)
    private String empMiddleName;

    @Column(name = "emp_last_name", length = 200)
    private String empLastName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_design_id", referencedColumnName = "id")
    private EmpDesignation empDesignId; //foreign key to emp_designation

    @Column(name = "office_room_no")
    private String officeRoomNo;

    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private LabMaster labId; //foreign key to lab_master

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_role_id", referencedColumnName = "id") 
    private EmpRole empRoleId; //foreign key to emp_role

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    
   
    @Column(name = "viewing_order", length = 2)
    private String viewingOrder = "-1";  //need to change the ordering system

    @Column(name = "addl_design", length = 200)
    private String addlDesign;

    @Column(name = "deleted", nullable = false, length = 1)
    private String deleted = "0";
    
    
    //	Constructors
    
    public EmpMaster () {}
    
    
    public EmpMaster(Integer id, String empTitle, String empFirstName, String empMiddleName, String empLastName,
			EmpDesignation empDesignId, String officeRoomNo, LabMaster labId, EmpRole empRoleId,
			LocalDateTime lastUpdated, String viewingOrder, String addlDesign, String deleted) {
		super();
		this.id = id;
		this.empTitle = empTitle;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.empDesignId = empDesignId;
		this.officeRoomNo = officeRoomNo;
		this.labId = labId;
		this.empRoleId = empRoleId;
		this.lastUpdated = lastUpdated;
		this.viewingOrder = viewingOrder;
		this.addlDesign = addlDesign;
		this.deleted = deleted;
	}

	//Getters and Setters
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpMiddleName() {
		return empMiddleName;
	}

	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public EmpDesignation getEmpDesignId() {
		return empDesignId;
	}

	public void setEmpDesignId(EmpDesignation empDesignId) {
		this.empDesignId = empDesignId;
	}

	public String getOfficeRoomNo() {
		return officeRoomNo;
	}

	public void setOfficeRoomNo(String officeRoomNo) {
		this.officeRoomNo = officeRoomNo;
	}

	public LabMaster getLabId() {
		return labId;
	}

	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}

	public EmpRole getEmpRoleId() {
		return empRoleId;
	}

	public void setEmpRoleId(EmpRole empRoleId) {
		this.empRoleId = empRoleId;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getViewingOrder() {
		return viewingOrder;
	}

	public void setViewingOrder(String viewingOrder) {
		this.viewingOrder = viewingOrder;
	}

	public String getAddlDesign() {
		return addlDesign;
	}

	public void setAddlDesign(String addlDesign) {
		this.addlDesign = addlDesign;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
    
    
    
    
}
