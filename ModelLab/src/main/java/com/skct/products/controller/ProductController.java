package com.skct.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skct.products.model.Product;
import com.skct.products.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	ProductService serv;
	
	@GetMapping("view")
	public List<Product> getProducts() {
		return serv.getProducts();
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addProducts(@RequestBody List<Product> data) {
		if( !serv.addProducts(data) ) {
			return new ResponseEntity<>("Couldn't Add Product", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>("Product Details Added", HttpStatus.CREATED);
		}
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product data) {
		if( !serv.updateProduct(id, data) ) {
			return new ResponseEntity<>("Couldn't Find Product", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>("Product Detail Updated", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		if( !serv.deleteProduct(id) ) {
			return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
		}
	}
}
