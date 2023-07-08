package com.app.exception_handler;

import java.util.Map;
import com.app.custom_exception.*;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.app.dto.ApiResponse;

//how to tell SC, following class is a spring bean containing common advice to rest controllers, 
//regarding centralized exception handling

@RestControllerAdvice	//mandatory annotation //@ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
	//can contain single/multiple execution methods
	// how to tell SC that following method is exception handling method
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		// convert List<FieldError< --> Map : fieldName,def mesg
		Map<String,String> map=e.getFieldErrors()
								.stream()
								.collect(Collectors.toMap(f->f.getField(), f->f.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		//List<FieldError> getFieldErrors
		//API of FieldError class : getField : field name with error
		//getDefaultMessage : error message
	}
	
//	add another exception handling method to handle ResourceNotFound 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(e.getMessage()));
	}
	
	
	
	
	
	
	
}
