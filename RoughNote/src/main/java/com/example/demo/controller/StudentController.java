package com.example.demo.controller;

import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ActiveHistory;
import com.example.demo.model.Student;
import com.example.demo.repository.ActiveRepository;
import com.example.demo.repository.StudentRepository;


@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentRepository studRepo;
	
	@Autowired
	private ActiveHistory activeLog;
	@Autowired
	private ActiveRepository logRepo;
	
	@GetMapping("/view")
	public List<Student> getAll() {
		System.out.println(studRepo.findAll());
		return studRepo.findAll();
	}
	
	@SuppressWarnings("null")
	@PostMapping("/add")
	public String addUser(@RequestBody List<Student> datas) {
		for(Student data : datas) {
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			studRepo.save(data);
			
			activeLog.setRegno(data.getRegno());
			activeLog.setId(data.getId());
			activeLog.setActive(data.getActive());
			activeLog.setCreatedTime(LocalDateTime.parse(LocalDateTime.now().format(pattern), pattern));
			
			logRepo.save(activeLog);
		}
		
		return "Success";
	}
	
	@SuppressWarnings("null")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updatemethod(@PathVariable Long id,@RequestBody Student updatedData)
	{
		if(!isStudentExist(id)) {
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
		else
		{
			Student data = studRepo.findById(id).get();
			System.out.println(data.toString());
			
			BeanWrapper srcWrapper = new BeanWrapperImpl(updatedData);
			PropertyDescriptor[] props = srcWrapper.getPropertyDescriptors();
			for(PropertyDescriptor prop : props) {
				String propName = prop.getName();
				Object propVal = srcWrapper.getPropertyValue(propName);
				
				System.out.println(propVal);
				try {
					if(propVal != null && !propName.equals("id")) {
						BeanUtils.setProperty(data, propName, propVal);			
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			 studRepo.save(data);

			return new ResponseEntity<>("Updated User Data",HttpStatus.OK);			
		}
		
	}
	
	@SuppressWarnings("null")
	@DeleteMapping("/delete/{stu_id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long stu_id)
	{
		if(!isStudentExist(stu_id)) {
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		} else {
			Student s = studRepo.findById(stu_id).get();
			s.setActive(0);
			
			studRepo.save(s);
		}
		
		return new ResponseEntity<>("Deleted Student id " + stu_id, HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public BodyBuilder test() {
		return ResponseEntity.status(200);
	}
	
	
	private boolean isStudentExist(@NonNull Long id) {
		Optional<Student> s = studRepo.findById(id);
		if(!s.isPresent()) {
			return false;
		}
		
		return (s.get().getActive() == 1);
	}

}
