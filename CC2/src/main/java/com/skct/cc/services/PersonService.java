package com.skct.cc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skct.cc.model.Person;
import com.skct.cc.repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo repo;
	
	public List<Person> getPersons(){
		return repo.findAll();
	}
	
	public boolean addPerson(List<Person> data) {
		try {
			repo.saveAll(data);
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
