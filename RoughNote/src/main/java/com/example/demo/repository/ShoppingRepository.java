package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Shopping;

public interface ShoppingRepository extends JpaRepository<Shopping, Integer>{

}
