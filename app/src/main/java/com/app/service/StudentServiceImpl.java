package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entities.Student;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	//dependency injection
	@Autowired
	private StudentRepository stdRepo;
	@Autowired
	private ModelMapper modelMap;

	//method to get list of students
	@Override
	public List<Student> getAllStudents() {		
		return stdRepo.findAll();
	}

	////method to add students
	@Override
	public Student addStudent(Student std) {
		
		return stdRepo.save(std);
	}

	// method to delete students
	@Override
	public String deleteStudent(Long stdId) {
		String mesg="Invalid Id  !!!";
		if(stdRepo.existsById(stdId)) {
			stdRepo.deleteById(stdId);
			mesg="Student with Id="+stdId+" deleted";
		}
		return mesg;
	}

	@Override
	public Student getStdDetails(Long stdId) {
		
		return stdRepo.findById(stdId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid std Id !!!"));
	}

}
