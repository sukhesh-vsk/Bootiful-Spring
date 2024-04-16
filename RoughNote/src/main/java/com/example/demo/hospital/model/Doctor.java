package com.example.demo.hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, speciality;
	
	/*  Getters and Setters  */
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
