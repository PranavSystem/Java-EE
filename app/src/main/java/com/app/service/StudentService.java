package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student addStudent(Student std);
	
	String deleteStudent(Long stdId);
	
	Student getStdDetails(Long stdId);
	
	
}
