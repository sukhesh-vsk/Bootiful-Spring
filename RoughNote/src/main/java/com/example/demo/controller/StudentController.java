package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@RestController
public class StudentController {
	@Autowired
	private StudentRepository studRepo;

	@GetMapping("/students")
	public List<Student> getAll() {
		return studRepo.findAll();
	}

	@PostMapping("adduser")
	public String addUser(@RequestBody @NonNull List<Student> data) {
		
		studRepo.saveAll(data);
		
		return "Success";
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updatemethod(@PathVariable String id,@RequestBody Student userData)
	{
		Optional<Student> userupdate = studRepo.findById(id);
		if(userupdate.isPresent()) {
			Student user=userupdate.get();
			user.setSname(userData.getSname());
			studRepo.save(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@SuppressWarnings("null")
	@DeleteMapping(path="/delete/{stu_id}")
	public void deleteUser(@PathVariable String stu_id)
	{
		studRepo.deleteById(stu_id);
	}
}
