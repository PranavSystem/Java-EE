package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AuthRequestDTO;
import com.app.dto.AuthResponseDTO;
import com.app.entities.Author;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	//dependency Injection
	@Autowired
	private AuthorRepository authRepo;
	@Autowired 
	private ModelMapper mapper;

	//get all authors
	@Override
	public List<Author> getAuthors() {
		
		return authRepo.findAll();
	}

	//add new authors
	@Override
	public Author addAuthor(Author author) {
		
		return authRepo.save(author);
	}

	//delete author by Id
	@Override
	public String deleteAuthor(Long authId) {
		String mesg="Invalid Id !!!";
		if(authRepo.existsById(authId)) {
			authRepo.deleteById(authId);
			mesg="Author with Id="+authId+" deleted";
		}
		return mesg;
	}

	//get author details by id
	@Override
	public Author getAuthorDetails(Long authId) {
		
		return authRepo.findById(authId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Id !!!"));
	}

	//update author details
	@Override
	public Author updateAuthor(Author authorDetails) {
		
		return authRepo.save(authorDetails);
	}

	// validation
	@Override
	public AuthResponseDTO validateSome(AuthRequestDTO req) {
		Author auth=authRepo.findByAuthorNameAndEmail(req.getAuthorName(), req.getEmail())
				.orElseThrow(()->new ResourceNotFoundException("Invalid Author name or Email !!!"));
		AuthResponseDTO authResponseDTO=mapper.map(auth, AuthResponseDTO.class);
		return authResponseDTO;
	}
	
	
	 
	

}
