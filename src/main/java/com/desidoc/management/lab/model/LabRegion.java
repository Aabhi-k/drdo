package com.desidoc.management.lab.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_region")
public class LabRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "region_short_name", length = 45)
    private String regionShortName;

    @Column(name = "region_full_name", length = 200)
    private String regionFullName;

    //constructors
    public LabRegion() {
    }

    public LabRegion(Integer id, String regionShortName, String regionFullName) {
        super();
        this.id = id;
        this.regionShortName = regionShortName;
        this.regionFullName = regionFullName;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionShortName() {
        return regionShortName;
    }

    public void setRegionShortName(String regionShortName) {
        this.regionShortName = regionShortName;
    }

    public String getRegionFullName() {
        return regionFullName;
    }

    public void setRegionFullName(String regionFullName) {
        this.regionFullName = regionFullName;
    }

}
