package com.skct.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skct.cc.model.Person;
import com.skct.cc.services.PersonService;

@RestController
@RequestMapping("persons")
public class PersonController {
	
	@Autowired
	private PersonService serv;
	
	@GetMapping("/view")
	public List<Person> getPersons() {
		return serv.getPersons();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addPerson(@RequestBody List<Person> data) {
		if( !serv.addPerson(data) ) {
			return new ResponseEntity<>("Couldn't Add Person Details", HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>("Successfull Add Person Details", HttpStatus.CREATED);
	}
}
