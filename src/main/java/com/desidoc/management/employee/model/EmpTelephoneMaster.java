package com.desidoc.management.employee.model;

import com.desidoc.management.others.telephone.TelephoneCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "emp_telephone_master")
public class EmpTelephoneMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private EmpMaster empId; //foreign key to emp_master

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tele_cat_id")
    private TelephoneCategory teleCatId; //foreign key to telephoneCategory

    @Column(name = "telephone_number", length = 45)
    private String telephoneNumber;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "epabx", length = 45)
    private String epabx;

    // Constructors

    public EmpTelephoneMaster() {
    }

    public EmpTelephoneMaster(Integer id, EmpMaster empId, TelephoneCategory teleCatId, String telephoneNumber,
                              LocalDateTime lastUpdated, String epabx) {
        super();
        this.id = id;
        this.empId = empId;
        this.teleCatId = teleCatId;
        this.telephoneNumber = telephoneNumber;
        this.lastUpdated = lastUpdated;
        this.epabx = epabx;
    }

    //	Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmpMaster getEmpId() {
        return empId;
    }

    public void setEmpId(EmpMaster empId) {
        this.empId = empId;
    }

    public TelephoneCategory getTeleCatId() {
        return teleCatId;
    }

    public void setTeleCatId(TelephoneCategory teleCatId) {
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
