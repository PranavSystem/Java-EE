package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@MappedSuperclass		// to tell MVC that this is super class of all classes extending from this class
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
}
