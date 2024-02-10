package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Employee;

// EMPLOYEE SERVICE INTERFACE
public interface EmployeeService {
	List<Employee> findAll();

	Employee save(Employee employee);

	Employee findById(int id);

	void deleteById(int id);

	List<Employee> findByFirstNameContainingIgnoreCase(String firstname);

	List<Employee> sort(String order, String orderBy);
}
