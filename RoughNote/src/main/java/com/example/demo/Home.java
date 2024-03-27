package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@GetMapping("/")
	String home() {
		return "Hello, World !!";
	}
	
	@GetMapping("/home")
	public String homepage() {
		return "Welcome to home page";
	}
	
	@GetMapping("/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		return a+b;
	}
}
