package com.desidoc.management.lab.dto;

import java.time.LocalDateTime;

public class LabFaxMasterDTO {
    private Integer id;
    private Integer stdCodeId; // Assuming this will hold the ID of the StdCodeMaster
    private String faxNo;
    private Integer labId; // Assuming this will hold the ID of the LabMaster
    private Integer faxCatId; // Assuming this will hold the ID of the LabFaxCategory
    private LocalDateTime lastUpdated;

    // Constructors
    public LabFaxMasterDTO() {
    }

    public LabFaxMasterDTO(Integer id, Integer stdCodeId, String faxNo, Integer labId, Integer faxCatId, LocalDateTime lastUpdated) {
        this.id = id;
        this.stdCodeId = stdCodeId;
        this.faxNo = faxNo;
        this.labId = labId;
        this.faxCatId = faxCatId;
        this.lastUpdated = lastUpdated;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStdCodeId() {
        return stdCodeId;
    }

    public void setStdCodeId(Integer stdCodeId) {
        this.stdCodeId = stdCodeId;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getFaxCatId() {
        return faxCatId;
    }

    public void setFaxCatId(Integer faxCatId) {
        this.faxCatId = faxCatId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}