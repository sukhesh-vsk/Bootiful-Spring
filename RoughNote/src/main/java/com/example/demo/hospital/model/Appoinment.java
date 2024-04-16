package com.example.demo.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appoinment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate date = LocalDate.now();
	private LocalTime time = LocalTime.now();
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient_id;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor_id;

	/*  Getters and Setters  */
	
	public int getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public LocalTime getTime() {
		return time;
	}
	public Patient getPatient_id() {
		return patient_id;
	}
	public Doctor getDoctor_id() {
		return doctor_id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}
	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

}
