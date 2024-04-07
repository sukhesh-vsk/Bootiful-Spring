package com.example.demo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ActiveHistory;
import com.example.demo.repository.ActiveRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActiveRepository logRepo;
	
	public List<ActiveHistory> viewLog() {
		return logRepo.findAll();
	}
	
	public String addLog(List<ActiveHistory> datas) {
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
