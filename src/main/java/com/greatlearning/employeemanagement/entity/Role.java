package com.greatlearning.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// MODEL FOR ROLE TABLE IN DATABASE
@Entity
@Table(name = "roles")
@Data
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleid")
	private int roleid;

	@Column(name = "name")
	private String name;

}
