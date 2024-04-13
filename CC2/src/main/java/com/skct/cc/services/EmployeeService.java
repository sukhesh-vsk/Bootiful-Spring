package com.skct.cc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.skct.cc.model.Employee;
import com.skct.cc.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> getEmployees(int pg, int size) {
		PageRequest page = PageRequest.of(pg, size, Sort.by(Direction.DESC, "salary"));
		return repo.findAll(page).getContent();
	}
	
	public boolean addEmployees(List<Employee> data) {
		try {
			repo.saveAll(data);
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public List<Employee> getByPlace() {
		return repo.findByPlace();
	}
	
	public List<Employee> getBySalary() {
		return repo.findBySalary();
	}
	
	public List<Employee> getCoimbatore() {
		return repo.findEmployeeCoimbatore();
	}
}
