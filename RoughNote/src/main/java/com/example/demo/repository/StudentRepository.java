package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s where s.active=1")
	public List<Student> findAllStudent(Pageable pageable);
}