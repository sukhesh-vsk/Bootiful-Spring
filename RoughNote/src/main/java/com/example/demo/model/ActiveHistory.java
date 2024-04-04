package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class ActiveHistory {
	// Data Model for Active Logs
	@Id
	private long id;
	
	@Column(unique=true) 
	private String regno;
	
	@Column(nullable = false, columnDefinition="INTEGER DEFAULT 1")
	private int active = 1;
	
	@Column(nullable = false, columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdTime;
	
	private LocalDateTime deletedTime;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Student stud; 
	
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
	public int getActive() {
		return active;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public LocalDateTime getDeletedTime() {
		return deletedTime;
	}
	
	// Setters
	public void setId(long id) {
		this.id = id;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public void setDeletedTime(LocalDateTime deletedTime) {
		this.deletedTime = deletedTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	
	
    /*
     *  Getters and Setters End   
     *  
     */
	

	
	
}
