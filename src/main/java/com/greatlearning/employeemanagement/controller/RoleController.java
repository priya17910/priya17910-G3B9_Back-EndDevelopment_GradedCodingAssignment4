package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.service.RoleService;

// ROLE CONTROLLER CLASS
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping
	public ResponseEntity<Role> addRole(@RequestBody Role role) {
		Role savedRole = roleService.addRole(role);
		return ResponseEntity.ok(savedRole);
	}
}
