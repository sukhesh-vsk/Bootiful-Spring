package com.skct.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skct.products.model.Product;
import com.skct.products.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
	public boolean addProducts(List<Product> data) {
		try {
			repo.saveAll(data);			
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean updateProduct(int id, Product newdata) {
		if( !this.findProduct(id) ) {
			return false;
		} else {
			Product data = repo.findById(id).get();
			if(newdata.getName() != null)
				data.setName(newdata.getName());
			if(newdata.getCategory() != null)
				data.setCategory(newdata.getCategory());
			if(!Double.isNaN(newdata.getPrice()))
				data.setPrice(newdata.getPrice());
			
			repo.save(data);
		}
		
		return true;
	}
	
	public boolean deleteProduct(int id) {
		if( !this.findProduct(id) ) {
			return false;
		} else {
			repo.deleteById(id);
		}
		
		return true;
	}
	
	public boolean findProduct(int id) {
		Optional<Product> s = repo.findById(id);
		return s.isPresent();
	}
}
