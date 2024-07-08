package com.desidoc.management.lab.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lab_epabx_master")
public class LabEpabxMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "epabx", length = 45)
    private String epabx;

    @Column(name = "did_no", length = 45)
    private String didNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private LabMaster labId; // foreign key to labMaster

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    //	Constructors

    public LabEpabxMaster() {
    }

    public LabEpabxMaster(Integer id, String epabx, String didNo, LabMaster labId, LocalDateTime lastUpdted) {
        super();
        this.id = id;
        this.epabx = epabx;
        this.didNo = didNo;
        this.labId = labId;
        this.lastUpdated = lastUpdted;
    }


    // Getters and Setter

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

    public LabMaster getLabId() {
        return labId;
    }

    public void setLabId(LabMaster labId) {
        this.labId = labId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


}
