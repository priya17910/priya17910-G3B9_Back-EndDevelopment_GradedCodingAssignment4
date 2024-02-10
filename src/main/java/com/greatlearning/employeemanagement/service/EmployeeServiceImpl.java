package com.greatlearning.employeemanagement.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;

// CLASS IMPLEMENTING METHODS OF EMPLOYEE SERVICE INTERFACE
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	// SERVICE METHOD TO GET LIST OF ALL THE EMPLOYEES
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	// SERVICE METHOD TO SAVE THE EMPLOYEE DATA IN DATABASE
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	// SERVICE METHOD TO FIND EMPLOYEE DATA BY ID
	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee not found with given id: " + id));
	}

	// SERVICE METHOD TO DELETE EMPLOYEE DATA BY ID
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	// SERVICE METHOD TO SEARCH EMPLOYEE DATA USING FIRSTNAME
	@Override
	public List<Employee> findByFirstNameContainingIgnoreCase(String firstName) {
		return employeeRepository.findByFirstNameContainingIgnoreCase(firstName);
	}

	// SERVICE METHOD TO SORT THE LIST OF EMPLOYEES
	@Override
	public List<Employee> sort(String order, String orderBy) {
		if (order.equalsIgnoreCase("asc")) {
			return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
		} else {
			return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
		}
	}

}
