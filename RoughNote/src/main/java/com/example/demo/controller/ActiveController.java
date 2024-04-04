package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActiveHistory;
import com.example.demo.repository.ActiveRepository;

@RestController
@RequestMapping("/log")
public class ActiveController {

	@Autowired
	private ActiveRepository logRepo;
	
	@GetMapping("/view")
	public List<ActiveHistory> viewHistory() {
		
		return logRepo.findAll();
	}
	
	@PostMapping("/add")
	public String addLog(@RequestBody List<ActiveHistory> datas) {
		for(ActiveHistory data : datas) {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String createtime_ = LocalDateTime.now().format(pattern);
			LocalDateTime createdTime = LocalDateTime.parse(createtime_ , pattern);
			data.setCreatedTime(createdTime);

			logRepo.save(data);
		}
		
		return "Added New Log";
	}
}
