package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Component
public class Student {
	@Id
	@GeneratedValue
	private long regno;
	private String sname, email;
	private double cgpa;

	public long getRegNo() {
		return regno;
	}

	public void setRegNo(long regno) {
		this.regno = regno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
}
