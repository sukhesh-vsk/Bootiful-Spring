package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActiveHistory;
import com.example.demo.services.ActivityService;

@RestController
@RequestMapping("/log")
public class ActiveController {

	@Autowired
	private ActivityService serviceLog;
	
	@GetMapping("/view")
	public List<ActiveHistory> viewHistory() {
		
		return serviceLog.viewLog();
	}
	
	@PostMapping("/add")
	public String addLog(@RequestBody List<ActiveHistory> datas) {
		
		return serviceLog.addLog(datas);
	}
}
