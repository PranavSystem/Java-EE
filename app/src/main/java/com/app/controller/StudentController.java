package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDTO;
import com.app.entities.Student;
import com.app.service.StudentService;




@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {
	//dependency injection
	@Autowired
	private StudentService stdService;
	
	
	public StudentController() {
		System.out.println("In def constr of Std controller");
	}
	
	//method to get list of students
	@GetMapping
	public List<Student> getAllStudents(){
		return stdService.getAllStudents();
	}
	
	//method to add students
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody Student std){
		System.out.println("In post std");
		return new ResponseEntity<>(stdService.addStudent(std), HttpStatus.CREATED);
	}
	
	// method to delete students
	@DeleteMapping("/{stdId}")
	public ApiResponse deleteStudent(@PathVariable Long stdId) {
		return new ApiResponse(stdService.deleteStudent(stdId));
	}
	
	// method to get std details with empId
	@GetMapping("/{stdId}")
	public Student getStdDetails(@PathVariable Long stdId) {
		return stdService.getStdDetails(stdId);
	}	
	
	// sign-in
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateStd(@RequestBody @Valid AuthRequestDTO req){
		return null;
	}
	
	
}
