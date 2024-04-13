package com.skct.cc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BloodGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bid;
	
	@Column(name = "blood_group") 
	private String group;

	public long getId() {
		return bid;
	}

	public String getGroup() {
		return group;
	}

	public void setId(long id) {
		this.bid = id;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
}
