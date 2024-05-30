package com.desidoc.management.others.event;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_log")
public class EventLogs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username", length = 100)
	private String username;
	
	@Column(name = "event", length = 255)
	private String event;
	
	@Column(name = "remarks", length = 255)
	private String remarks;
	
	@Column(name = "ip", length = 45)
	private String ip;
	
	@Column(name = "date_of_entry")
	private LocalDateTime dateOfEntry;

	// Constructors
	
	public EventLogs() {}
	
	public EventLogs(Integer id, String username, String event, String remarks, String ip, LocalDateTime dateOfEntry) {
		super();
		this.id = id;
		this.username = username;
		this.event = event;
		this.remarks = remarks;
		this.ip = ip;
		this.dateOfEntry = dateOfEntry;
	}
	
	//	Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public LocalDateTime getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(LocalDateTime dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	
	
	
	
	
	

}
