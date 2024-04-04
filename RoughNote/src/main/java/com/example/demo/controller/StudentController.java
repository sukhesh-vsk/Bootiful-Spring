package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.ActiveHistory;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.ActiveRepository;


@RestController
public class StudentController {
	@Autowired
	private StudentRepository studRepo;
	
	@Autowired
	private ActiveHistory activeLog;
	@Autowired
	private ActiveRepository logRepo;
	
	@GetMapping("/students")
	public List<Student> getAll() {
		System.out.println(studRepo.findAll());
		return studRepo.findAll();
	}
	
	@SuppressWarnings("null")
	@PostMapping("/adduser")
	public String addUser(@RequestBody List<Student> datas) {
		for(Student data : datas) {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			studRepo.save(data);
			
			activeLog.setRegno(data.getRegno());
			activeLog.setId(data.getId());
			activeLog.setActive(data.getActive());
			activeLog.setCreatedTime(LocalDateTime.parse(LocalDateTime.now().format(pattern), pattern));
			
			logRepo.save(activeLog);
		}
		
		return "Success";
	}
	
	@SuppressWarnings("null")
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updatemethod(@PathVariable Long id,@RequestBody Student userData)
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
	public void deleteUser(@PathVariable Long stu_id)
	{
		studRepo.deleteById(stu_id);
	}
}
