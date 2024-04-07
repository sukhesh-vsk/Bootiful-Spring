package com.example.demo.services;

import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.demo.model.ActiveHistory;
import com.example.demo.model.Student;
import com.example.demo.repository.ActiveRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studRepo;
	@Autowired
	ActiveHistory activeLog;
	@Autowired
	ActiveRepository logRepo;

	public List<Student> getAllStudents(int pageNumber, int pageSize) {
		PageRequest page = PageRequest.of(pageNumber, pageSize, Sort.by("id"));
		return studRepo.findAll(page).getContent();
	}

	public String addStudents(List<Student> datas) {
		for (Student data : datas) {
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

	public ResponseEntity<String> updateStudent(Long id, Student updatedData) {
		Student data = studRepo.findById(id).get();
		BeanWrapper srcWrapper = new BeanWrapperImpl(updatedData);
		PropertyDescriptor[] props = srcWrapper.getPropertyDescriptors();
		
		for (PropertyDescriptor prop : props) {
			String propName = prop.getName();
			Object propVal = srcWrapper.getPropertyValue(propName);

			try {
				if (propVal != null && !propName.equals("id")) {
					BeanUtils.setProperty(data, propName, propVal);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			studRepo.save(data);
		}

		return new ResponseEntity<>("Updated User Data", HttpStatus.OK);
	}

	public ResponseEntity<String> deleteStudent(Long stu_id) {
		Student s = studRepo.findById(stu_id).get();
		s.setActive(0);
		studRepo.save(s);

		return new ResponseEntity<>("Deleted Student id " + stu_id, HttpStatus.OK);
	}

	public boolean isStudentExist(@NonNull Long id) {
		Optional<Student> s = studRepo.findById(id);
		if (!s.isPresent()) {
			return false;
		}

		return (s.get().getActive() == 1);
	}
}
