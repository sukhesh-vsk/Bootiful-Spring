package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository studRepo;
	
	public StudentController() {}
	
	public StudentController(StudentRepository studRepo) {
		this.studRepo = studRepo;
	}

	@GetMapping("/students")
	public List<Student> getAll() {
		return studRepo.findAll();
	}

	@PostMapping("/setUser")
	public Student newUser(@RequestBody Student newStudent) {
		
		return studRepo.save(newStudent);
	}
}
