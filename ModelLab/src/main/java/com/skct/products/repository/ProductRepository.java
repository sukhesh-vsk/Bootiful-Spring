package com.skct.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skct.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
