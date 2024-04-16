package com.example.demo.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hospital.model.Patient;
import com.example.demo.hospital.repository.PatientRepo;

@Service
public class PatientService {
	@Autowired private PatientRepo pr;
	
	public List<Patient> getPatients() {
		return pr.findAll();
	}
	
	public String addNewPatient(List<Patient> data) {
		try {
			pr.saveAll(data);
		} catch(Exception e) {
			return e.getMessage();
		}
		
		return "Patient data added..!!";		
	}
}
