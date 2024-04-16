package com.example.demo.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hospital.model.Doctor;
import com.example.demo.hospital.repository.DoctorRepo;

@Service
public class DoctorService {
	@Autowired private DoctorRepo pr;
	
	public List<Doctor> getDoctors() {
		return pr.findAll();
	}
	
	public String addNewDoctor(List<Doctor> data) {
		try {
			pr.saveAll(data);
		} catch(Exception e) {
			return e.getMessage();
		}
		
		return "Doctor data added..!!";		
	}
}
