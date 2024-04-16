package com.example.demo.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hospital.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}