package com.desidoc.management.lab.dto;

import java.time.LocalDateTime;

public class LabTelephoneMasterDTO {
    private Integer id;
    private Integer labId; // Assuming this will hold the ID of the LabMaster
    private Integer teleCatId; // Assuming this will hold the ID of the TelephoneCategory
    private Integer stdCodeId; // Assuming this will hold the ID of the StdCodeMaster
    private String telephoneNumber;
    private LocalDateTime lastUpdated;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getTeleCatId() {
        return teleCatId;
    }

    public void setTeleCatId(Integer teleCatId) {
        this.teleCatId = teleCatId;
    }

    public Integer getStdCodeId() {
        return stdCodeId;
    }

    public void setStdCodeId(Integer stdCodeId) {
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