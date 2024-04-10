package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserQuery;
import com.example.demo.repository.UserQueryRepo;

@Service
public class UserQueryService {

	@Autowired
	private UserQueryRepo userRepo;
	
	public List<UserQuery> getUsers() {
		return userRepo.findAll();
	}
	
	public boolean addUsers(List<UserQuery> data) {
		try {
			userRepo.saveAll(data);			
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
