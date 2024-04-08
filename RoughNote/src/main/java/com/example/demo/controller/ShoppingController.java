package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shopping;
import com.example.demo.services.ShoppingService;

@RestController
@RequestMapping("store")
public class ShoppingController {
	
	@Autowired
	ShoppingService shop;
	
	@GetMapping("products")
	public List<Shopping> getAllProducts() {
		return shop.getAllProducts();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addProducts(@RequestBody List<Shopping> S) {
		shop.addProducts(S);
		
		return new ResponseEntity<>("Added products", HttpStatus.CREATED);
	}
	
}
