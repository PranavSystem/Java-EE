package com.app.service;

import java.util.List;

import com.app.dto.AuthRequestDTO;
import com.app.dto.AuthResponseDTO;
import com.app.entities.Author;

public interface AuthorService {
	List<Author> getAuthors();
	
	Author addAuthor(Author author);
	
	String deleteAuthor(Long authId);
	
	Author getAuthorDetails(Long authId);
	
	Author updateAuthor(Author authorDetails);
	
	AuthResponseDTO validateSome(AuthRequestDTO req);
}
