package com.skct.cc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skct.cc.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}
