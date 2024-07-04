package com.desidoc.management.password.model;

import com.desidoc.management.lab.model.LabMaster;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "forget_password_link_status")
public class ForgetPasswordLinkStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mail_id", length = 200)
    private String mailId;

    @Column(name = "token", length = 45)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private LabMaster labId; //foreign key to LabMaster

    @Column(name = "link_status", length = 45)
    private String linkStatus;

    @Column(name = "date_of_entry")
    private LocalDateTime dateOfEntry;

    // Constructors
    public ForgetPasswordLinkStatus() {
    }

    public ForgetPasswordLinkStatus(Integer id, String mailId, String token, LabMaster labId, String linkStatus,
                                    LocalDateTime dateOfEntry) {
        super();
        this.id = id;
        this.mailId = mailId;
        this.token = token;
        this.labId = labId;
        this.linkStatus = linkStatus;
        this.dateOfEntry = dateOfEntry;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LabMaster getLabId() {
        return labId;
    }

    public void setLabId(LabMaster labId) {
        this.labId = labId;
    }

    public String getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(String linkStatus) {
        this.linkStatus = linkStatus;
    }

    public LocalDateTime getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDateTime dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }


}