package com.greatlearning.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// MODEL FOR EMPLOYEE TABLE IN DATABASE
@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;
}
