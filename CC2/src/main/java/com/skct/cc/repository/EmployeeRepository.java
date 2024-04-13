package com.skct.cc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skct.cc.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT E FROM Employee E WHERE E.place IN ('Bangalore', 'Coimbatore', 'Chennai')")
	public List<Employee> findByPlace();
	
	@Query("SELECT E FROM Employee E WHERE E.place='Chennai' OR E.salary>=80000")
	public List<Employee> findBySalary();
	
	@Query("SELECT E FROM Employee E WHERE E.place='Coimbatore' AND E.salary>=40000")
	public List<Employee> findEmployeeCoimbatore();

}
