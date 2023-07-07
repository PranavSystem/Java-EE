package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {
	@NotBlank(message = "email cannot be blank")
	private String email;
	@NotBlank(message = "password cannot be blank")
	private String password;
}
