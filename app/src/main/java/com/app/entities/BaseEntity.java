package com.app.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass   // to tell MVC that this is super class of all entity classes
@Getter
@Setter
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
}
