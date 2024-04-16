package com.example.demo.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, issue;
	
	@Column(name = "phno")
	private String phNo;

	/*  Getters and Setters  */
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhNo() {
		return phNo;
	}
	public String getIssue() {
		return issue;
	}
	
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	
}
