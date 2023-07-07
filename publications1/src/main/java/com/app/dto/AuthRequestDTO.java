package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {
	@NotBlank(message = "Author name should not be blank !!!")
	private String authorName;
	@NotBlank(message = "Email should not be blank !!!")
	private String email;
}
