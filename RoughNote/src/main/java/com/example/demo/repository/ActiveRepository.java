package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ActiveHistory;

@Repository
public interface ActiveRepository extends JpaRepository<ActiveHistory, Long> {

}
