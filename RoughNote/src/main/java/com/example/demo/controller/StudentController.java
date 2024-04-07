package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService stud;
	
	@GetMapping("/view/{page}/{size}")
	public List<Student> getAll(@PathVariable int page, @PathVariable int size) {
		return stud.getAllStudents(page, size);
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody List<Student> datas) {
		return stud.addStudents(datas);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updatemethod(@PathVariable Long id,@RequestBody Student updatedData)
	{
		if(!stud.isStudentExist(id)) {
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
		
		stud.updateStudent(id, updatedData);
		return new ResponseEntity<>("Updated User Data",HttpStatus.OK);			
		
	}
	
	@DeleteMapping("/delete/{stu_id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long stu_id)
	{
		if(!stud.isStudentExist(stu_id)) {
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
	
		stud.deleteStudent(stu_id);
		
		return new ResponseEntity<>("Deleted Student id " + stu_id, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public BodyBuilder test() {
		return ResponseEntity.status(200);
	}
}
