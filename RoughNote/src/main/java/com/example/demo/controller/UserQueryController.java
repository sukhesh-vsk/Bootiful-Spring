package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserQuery;
import com.example.demo.services.UserQueryService;

@RestController
@RequestMapping("user")
public class UserQueryController {
	@Autowired
	UserQueryService userService;
	
	@GetMapping("all")
	public List<UserQuery> getAllUser() {
		return userService.getUsers();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addUsers(@RequestBody List<UserQuery> data) {
		String body[] = (userService.addUsers(data)) ? new String[] {"201", "User Added"} : new String[] {"400", "Couldn't add User"};
		return ResponseEntity.status(Integer.parseInt(body[0])).body(body[1]);
	}
}
