package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ActiveHistory {
	// Data Model for Active Logs
	@Id
	private long id;
	
	@Column(unique=true) 
	private String regno;
	
	@Column(nullable = false, columnDefinition="BOOLEAN DEFAULT true")
	private boolean active;
	
	@Column(nullable = false, columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdTime;
	private LocalDateTime deletedTime;
	
	
    /*
     *  Getters and Setters Start   
     *  
     */

	public long getId() {
		return id;
	}
	public String getRegno() {
		return regno;
	}
	public boolean isActive() {
		return active;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public LocalDateTime getDeletedTime() {
		return deletedTime;
	}
	
	// Setters
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setDeletedTime(LocalDateTime deletedTime) {
		this.deletedTime = deletedTime;
	}	
	
    /*
     *  Getters and Setters End   
     *  
     */
	

	
	
}
