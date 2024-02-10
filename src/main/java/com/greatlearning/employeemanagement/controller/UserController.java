package com.greatlearning.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.service.UserService;

// USER CONTROLLER CLASS
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;


	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userService.addUser(user);
		return ResponseEntity.ok(savedUser);
	}
}
