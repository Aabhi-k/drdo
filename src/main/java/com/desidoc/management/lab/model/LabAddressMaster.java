package com.desidoc.management.lab.model;

import com.desidoc.management.others.city.CityMaster;
import com.desidoc.management.others.city.ZipcodeMaster;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lab_address_master")
public class LabAddressMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private LabMaster labId; //foreign key to LabMaster

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityMaster cityId; //foreign key to CityMaster

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zipcode_id", referencedColumnName = "id")
    private ZipcodeMaster zipcodeId; //foreign key to ZipcodeMaster

    @Column(name = "address_line1", length = 200)
    private String addressLine1;

    @Column(name = "address_line2", length = 200)
    private String addressLine2;

    @Column(name = "address_line3", length = 200)
    private String addressLine3;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    //	Constructors

    public LabAddressMaster() {
    }


    public LabAddressMaster(Integer id, LabMaster labId, String addressLine1, String addressLine2, String addressLine3,
                            CityMaster cityId, ZipcodeMaster zipcodeId, LocalDateTime lastUpdated) {
        super();
        this.id = id;
        this.labId = labId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.cityId = cityId;
        this.zipcodeId = zipcodeId;
        this.lastUpdated = lastUpdated;
    }


    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public CityMaster getCityId() {
        return cityId;
    }

    public void setCityId(CityMaster cityId) {
        this.cityId = cityId;
    }

    public ZipcodeMaster getZipcodeId() {
        return zipcodeId;
    }

    public void setZipcodeId(ZipcodeMaster zipcodeId) {
        this.zipcodeId = zipcodeId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    public LabMaster getLabId() {
        return labId;
    }


    public void setLabId(LabMaster labId) {
        this.labId = labId;
    }


}
