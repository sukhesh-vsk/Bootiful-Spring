package com.example.demo.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hospital.model.Patient;
import com.example.demo.hospital.service.PatientService;

@RestController
@RequestMapping("patients")
public class PatientCont {
@Autowired private PatientService serv;
	
	@GetMapping("view")
	public List<Patient> getPatients() {
		return serv.getPatients();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addNewPatients(@RequestBody List<Patient> data) {
		return ResponseEntity.status(200).body(serv.addNewPatient(data));
//        try {
//            String message = serv.addNewPatient(data);
//            return ResponseEntity.status(HttpStatus.OK).body(message);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
    }
}
