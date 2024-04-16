package com.example.demo.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hospital.model.Appoinment;
import com.example.demo.hospital.repository.AppoinmentRepo;

@Service
public class AppoinmentService {
	@Autowired private AppoinmentRepo ar;
	
	public List<Appoinment> getAppoinments() {
		return ar.findAll();
	}
	
	public String addNewAppoinment(List<Appoinment> data) {
		try {
			ar.saveAll(data);
		} catch(Exception e) {
			return e.getMessage();
		}
		
		return "Appoinment data added..!!";		
	}
}