package com.desidoc.management.lab.dto;

import java.time.LocalDateTime;

public class LabEpabxDTO {
    private Integer id;
    private String epabx;
    private String didNo;
    private Integer labId; // Assuming this will hold the ID of the LabMaster
    private LocalDateTime lastUpdated;

    // Getters and Setters
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

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}