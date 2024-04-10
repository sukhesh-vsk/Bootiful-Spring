package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Shopping {
	@Id
	@GeneratedValue
	public long id;
	
	public String pname;
	public double price;
	public double qty;
	
	@Transient
	public double totalPrice;

    /*
     *	Getters and Setters start 
     */
	public long getId() {
		return id;
	}

	public String getPname() {
		return pname;
	}

	public double getPrice() {
		return price;
	}

	public double getQty() {
		return qty;
	}

	public double getTotalPrice() {
		this.setTotalPrice();
		return totalPrice;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}
	
	public void setTotalPrice() {
		this.totalPrice = this.qty * this.price;
	}
	
	/*
     *	Getters and Setters end 
     */

}
