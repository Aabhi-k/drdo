package com.desidoc.management.employee.dto;

import java.time.LocalDateTime;

public class EmpMailMasterDTO {

    private Integer id;
    private String email;
    private Integer empId;
    private Integer mailCatId;
    private LocalDateTime lastUpdated;

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getMailCatId() {
        return mailCatId;
    }

    public void setMailCatId(Integer mailCatId) {
        this.mailCatId = mailCatId;
    }
}
