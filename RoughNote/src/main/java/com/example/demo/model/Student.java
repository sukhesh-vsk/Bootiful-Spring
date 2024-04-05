package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique=true) 
	private String regno, email;
	
	private String sname;
	@Column(nullable = true)
	private Double cgpa;
	
	@Column(nullable = false, columnDefinition = "INTEGER DEFAULT 1")
	private int active = 1;
	
	@OneToOne(mappedBy="stud", cascade = CascadeType.ALL)
	private ActiveHistory activeHistory;
	
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
	public Double getCgpa() {
		return cgpa;
	}
	public int getActive() {
		return active;
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
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public void setActive(int active) {
		this.active = active;
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
