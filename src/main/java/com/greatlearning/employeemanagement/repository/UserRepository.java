package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.entity.User;

// USER REPOSITORY CLASS EXTENDING JPA REPOSITORY
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
