package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
//lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity{
	@Column(name = "first_name",length = 10)
	private String firstName;
	@Column(name = "last_name",length = 10)
	private String lastName;
	@Email
	@Column(nullable = false)
	private String email;
	@Column(length = 15, nullable = false)
	private String password;
	@Column(name = "dob")
	private LocalDate birthDate;
	
}
