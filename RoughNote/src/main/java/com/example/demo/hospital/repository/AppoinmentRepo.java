package com.example.demo.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hospital.model.Appoinment;

@Repository
public interface AppoinmentRepo extends JpaRepository<Appoinment, Integer>  {

}
