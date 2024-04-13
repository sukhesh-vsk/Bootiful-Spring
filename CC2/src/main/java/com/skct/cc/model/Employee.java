package com.skct.cc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	private String name, place;
	private double salary;
	
	public long getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getPlace() {
		return place;
	}
	public double getSalary() {
		return salary;
	}
	
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
