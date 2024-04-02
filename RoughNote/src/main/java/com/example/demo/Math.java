package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Math {
	@GetMapping("/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		return a+b;
	}
	
	@GetMapping("/divi/{a}/{b}")
	public double divi(@PathVariable int a,@PathVariable int b) {		
		return (double) a/b;	
	}
}
