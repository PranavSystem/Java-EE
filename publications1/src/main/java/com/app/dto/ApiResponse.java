package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ApiResponse {
	private String mesg;
	private LocalDateTime timeStamp;
	
	public ApiResponse(String mesg) {
		this.mesg=mesg;
		this.timeStamp=LocalDateTime.now();
	}
}
