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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDTO;
import com.app.entities.Author;
import com.app.service.AuthorService;

import lombok.Value;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthorController {
	//dependency injection
	@Autowired
	private AuthorService authService;
	
	// get method to get all authors
	@GetMapping
	public List<Author> getAuthors(){
		return authService.getAuthors();
	}
	
	// post method to add new author
	@PostMapping
	public ResponseEntity<?> addAuthor(@RequestBody Author author) {
		
		return new ResponseEntity<>(authService.addAuthor(author), HttpStatus.CREATED);
	}
	
	// delete method to delete by id
	@DeleteMapping("/{authId}")
	public ApiResponse deleteAuthor(@PathVariable Long authId) {
		
		return new ApiResponse(authService.deleteAuthor(authId));		
	}
	
	// put method to update author details
	@PutMapping
	public Author updateAuthor(@RequestBody Author author) {
		
		return authService.updateAuthor(author);
	}
	
	
	
	// get method to get auth details by id
	@GetMapping("/{authId}")
	public Author getAuthorDetails(@PathVariable Long authId) {
		
		return authService.getAuthorDetails(authId);
	}
	
	// sign-in
	@PostMapping("/validate")
	public ResponseEntity<?> validateSome(@RequestBody @Valid AuthRequestDTO req) {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(authService.validateSome(req));
	}
}
