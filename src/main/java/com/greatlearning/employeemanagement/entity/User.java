package com.greatlearning.employeemanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

// MODEL FOR USER TABLE IN DATABASE
@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Role> roles = new ArrayList<>();
}
