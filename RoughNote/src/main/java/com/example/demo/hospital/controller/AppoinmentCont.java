package com.example.demo.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hospital.model.Appoinment;
import com.example.demo.hospital.service.AppoinmentService;

@RestController
@RequestMapping("schedule")
public class AppoinmentCont {
	@Autowired private AppoinmentService serv;
	
	@GetMapping("view")
	public List<Appoinment> getAppoinments() {
		return serv.getAppoinments();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addNewAppoinments(@RequestBody List<Appoinment> data) {
		return ResponseEntity.status(200).body(serv.addNewAppoinment(data));
	}
}
