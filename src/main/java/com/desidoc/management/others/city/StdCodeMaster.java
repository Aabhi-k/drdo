package com.desidoc.management.others.city;

import com.desidoc.management.lab.model.LabMaster;
import jakarta.persistence.*;

@Entity
@Table(name = "std_code_master")
public class StdCodeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "std_code", length = 10)
    private String stdCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private LabMaster labId; //Foreign key to labMaster


    //	constructors
    public StdCodeMaster() {
    }

    public StdCodeMaster(Integer id, String stdCode, LabMaster labId) {
        super();
        this.id = id;
        this.stdCode = stdCode;
        this.labId = labId;
    }

    //	Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public LabMaster getLabId() {
        return labId;
    }

    public void setLabId(LabMaster labId) {
        this.labId = labId;
    }


}
