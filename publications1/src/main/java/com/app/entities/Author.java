package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author extends BaseEntity{
	@Column(name="name",length=20)
	private String authorName;
	@Email
	private String email;
	private String address;
	@Column(nullable = false)
	private String book;
	private Double price;
	
	
	
	
	
	
}
