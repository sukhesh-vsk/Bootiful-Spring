package com.skct.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skct.cc.model.Employee;
import com.skct.cc.services.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService serv;
	
	@GetMapping("/view/{page}/{size}")
	public List<Employee> getEmployees(@PathVariable int page, @PathVariable int size) {
		return serv.getEmployees(page, size);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addEmployees(@RequestBody List<Employee> data) {
		if( !serv.addEmployees(data) ) {
			return new ResponseEntity<>("Couldn't Add Employee Details", HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>("Successfull Add Employee Details", HttpStatus.CREATED);
	}
	
	@GetMapping("places")
	public List<Employee> getByPlace() {
		return serv.getByPlace();
	}
	
	@GetMapping("salary")
	public List<Employee> getBySalary() {
		return serv.getBySalary();
	}
	@GetMapping("cbe")
	public List<Employee> getCoimbatore() {
		return serv.getCoimbatore();
	}
}
