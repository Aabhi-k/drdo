package com.desidoc.management.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_cadre")
public class EmpCadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cadre_id")
    private Integer cadreId;


    @Column(name = "cadre_short_name", length = 45)
    private String cadreShortName;

    @Column(name = "cadre_full_name", length = 200)
    private String cadreFullName;

    //	Constructors

    public EmpCadre() {
    }

    public EmpCadre(Integer cadreId, String cadreShortName, String cadreFullName) {
        super();
        this.cadreId = cadreId;
        this.cadreShortName = cadreShortName;
        this.cadreFullName = cadreFullName;
    }

    //	Getters and Setters

    public Integer getCadreId() {
        return cadreId;
    }

    public void setCadreId(Integer cadreId) {
        this.cadreId = cadreId;
    }

    public String getCadreShortName() {
        return cadreShortName;
    }

    public void setCadreShortName(String cadreShortName) {
        this.cadreShortName = cadreShortName;
    }

    public String getCadreFullName() {
        return cadreFullName;
    }

    public void setCadreFullName(String cadreFullName) {
        this.cadreFullName = cadreFullName;
    }


}
