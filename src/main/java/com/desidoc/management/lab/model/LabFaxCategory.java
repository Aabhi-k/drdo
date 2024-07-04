package com.desidoc.management.lab.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_fax_category")
public class LabFaxCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fax_cat_short_name", length = 200)
    private String faxCatShortName;

    @Column(name = "fax_cat_full_name", length = 200)
    private String faxCatFullName;

    public LabFaxCategory() {
    }

    public LabFaxCategory(Integer id, String faxCatShortName, String faxCatFullName) {
        super();
        this.id = id;
        this.faxCatShortName = faxCatShortName;
        this.faxCatFullName = faxCatFullName;
    }
    //getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaxCatShortName() {
        return faxCatShortName;
    }

    public void setFaxCatShortName(String faxCatShortName) {
        this.faxCatShortName = faxCatShortName;
    }

    public String getFaxCatFullName() {
        return faxCatFullName;
    }

    public void setFaxCatFullName(String faxCatFullName) {
        this.faxCatFullName = faxCatFullName;
    }

}
