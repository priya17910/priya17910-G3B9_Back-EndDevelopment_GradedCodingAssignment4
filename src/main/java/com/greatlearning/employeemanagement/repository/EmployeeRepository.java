package com.greatlearning.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.entity.Employee;

// EMPLOYEE REPOSITORY CLASS EXTENDING JPA REPOSITORY
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
}
