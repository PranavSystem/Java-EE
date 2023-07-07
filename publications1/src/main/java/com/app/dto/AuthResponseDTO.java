package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {
	private String authorName;
	private String address;
	private String book;
	private Double price;
}
