package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id @GeneratedValue private long id;
	
	@Column(unique=true) 
	private String regno, email;
	
	private String sname;
	double cgpa;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private boolean active;
	
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
	public String getSname() {
		return sname;
	}
	public String getEmail() {
		return email;
	}
	public double getCgpa() {
		return cgpa;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

    /*
     *  Getters and Setters End   
     */
	
	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getRegno()=" + getRegno() + ", getSname()=" + getSname()
				+ ", getEmail()=" + getEmail() + ", getCgpa()=" + getCgpa() + "]";
	}	
		
}
