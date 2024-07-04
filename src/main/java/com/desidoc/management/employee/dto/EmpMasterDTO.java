package com.desidoc.management.employee.dto;

import java.time.LocalDateTime;

public class EmpMasterDTO {
    private Integer id;
    private String empTitle;
    private String empFirstName;
    private String empMiddleName;
    private String empLastName;
    private Integer empDesignId; // foreign key reference to EmpDesignation
    private String officeRoomNo;
    private Integer labId; // foreign key reference to LabMaster
    private Integer empRoleId; // foreign key reference to EmpRole
    private LocalDateTime lastUpdated;
    private String viewingOrder;
    private String addlDesign;
    private String deleted;


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

    public Integer getEmpDesignId() {
        return empDesignId;
    }

    public void setEmpDesignId(Integer empDesignId) {
        this.empDesignId = empDesignId;
    }

    public String getOfficeRoomNo() {
        return officeRoomNo;
    }

    public void setOfficeRoomNo(String officeRoomNo) {
        this.officeRoomNo = officeRoomNo;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getEmpRoleId() {
        return empRoleId;
    }

    public void setEmpRoleId(Integer empRoleId) {
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
