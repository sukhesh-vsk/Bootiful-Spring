package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserQuery;

@Repository
public interface UserQueryRepo extends JpaRepository<UserQuery, Integer> {
	@Override
	@Query("SELECT u FROM UserQuery u")
	List<UserQuery> findAll();
}
