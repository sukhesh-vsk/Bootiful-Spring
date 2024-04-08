package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Shopping;
import com.example.demo.repository.ShoppingRepository;

@Service
public class ShoppingService {
	@Autowired
	ShoppingRepository shopRepo;
	
	public List<Shopping> getAllProducts() {
		return shopRepo.findAll();
	}
	
	public boolean addProducts(List<Shopping> S) {
		shopRepo.saveAll(S);
		
		return true;
	}
}
