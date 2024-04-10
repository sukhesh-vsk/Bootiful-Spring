package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserQuery {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String fname, lname, place;

	/* Getter and Setter Start */
	
	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPlace() {
		return place;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setPlace(String place) {
		this.place = place;
	}
		
	/* Getter and Setter End */
}
