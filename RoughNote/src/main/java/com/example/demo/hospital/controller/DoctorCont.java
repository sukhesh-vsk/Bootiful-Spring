package com.example.demo.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hospital.model.Doctor;
import com.example.demo.hospital.service.DoctorService;

@RestController
@RequestMapping("doctors")
public class DoctorCont {
@Autowired private DoctorService serv;
	
	@GetMapping("view")
	public List<Doctor> getDoctors() {
		return serv.getDoctors();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addNewDoctors(@RequestBody List<Doctor> data) {
		return ResponseEntity.status(200).body(serv.addNewDoctor(data));
	}
}