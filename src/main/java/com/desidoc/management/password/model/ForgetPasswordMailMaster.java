package com.desidoc.management.password.model;

import java.time.LocalDateTime;

import com.desidoc.management.lab.model.LabMaster;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "forget_password_mail_master")
public class ForgetPasswordMailMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mail_id")
    private String mailId;


    @ManyToOne
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    private LabMaster labId; // foreign key to labMaster

    @Column(name = "date_of_entry")
    private LocalDateTime dateOfEntry;
    
    // Constructors
    
    public ForgetPasswordMailMaster() {}

	public ForgetPasswordMailMaster(Integer id, String mailId, LabMaster labId, LocalDateTime dateOfEntry) {
		super();
		this.id = id;
		this.mailId = mailId;
		this.labId = labId;
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

	public LabMaster getLabId() {
		return labId;
	}

	public void setLabId(LabMaster labId) {
		this.labId = labId;
	}

	public LocalDateTime getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(LocalDateTime dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
    
    
	
	
	
    
    

}