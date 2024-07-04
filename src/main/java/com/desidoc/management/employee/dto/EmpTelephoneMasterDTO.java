package com.desidoc.management.employee.dto;

import java.time.LocalDateTime;

public class EmpTelephoneMasterDTO {
    private Integer id;
    private Integer empId;
    private Integer teleCatId;
    private String telephoneNumber;
    private LocalDateTime lastUpdated;
    private String epabx;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getTeleCatId() {
        return teleCatId;
    }

    public void setTeleCatId(Integer teleCatId) {
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
