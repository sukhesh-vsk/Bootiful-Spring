package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ActiveHistory;

public interface ActiveRepository extends JpaRepository<ActiveHistory, Long> {

}
