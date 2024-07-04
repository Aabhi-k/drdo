package com.desidoc.management.others.telephone;

import jakarta.persistence.*;

@Entity
@Table(name = "useful_tel_category")
public class UsefulTelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "cat_name", length = 200)
    private String catName;


    //constructors
    public UsefulTelCategory() {
    }


    public UsefulTelCategory(Integer catId, String catName) {
        super();
        this.catId = catId;
        this.catName = catName;
    }

    //Getters and Setters

    public Integer getCatId() {
        return catId;
    }


    public void setCatId(Integer catId) {
        this.catId = catId;
    }


    public String getCatName() {
        return catName;
    }


    public void setCatName(String catName) {
        this.catName = catName;
    }


}
