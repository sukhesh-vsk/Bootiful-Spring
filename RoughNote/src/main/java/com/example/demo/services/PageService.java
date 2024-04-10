package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@RestController
@RequestMapping("/page")
public class PageService {
	
	@Autowired
	private StudentRepository studRepo;
	
	@GetMapping("/view/{pageNum}/{size}")
	public Page<Student> getHighCGPAStudents(@PathVariable int pageNum,@PathVariable int size) {
		
		PageRequest page = PageRequest.of(pageNum, size, Sort.by(Direction.DESC ,"cgpa"));
		
		return studRepo.findAll(page);
	}

}
