package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

// EMPLOYEE CONTROLLER CLASS
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	// CONTROLLER METHOD TO GET THE COMPLETE LIST OF EMPLOYEES
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.findAll();
		return ResponseEntity.ok(employees);
	}

	// CONTROLLER METHOD TO ADD NEW EMPLOYEE DATA
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);
		return ResponseEntity.ok(savedEmployee);
	}

	// CONTROLLER METHOD TO GET EMPLOYEE BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee = employeeService.findById(id);
		return ResponseEntity.ok(employee);
	}

	// CONTROLLER METHOD TO UPDATE THE DATA OF EXISTING EMPLOYEE
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee existingEmployee = employeeService.findById(employee.getId());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setEmail(employee.getEmail());

		Employee updatedEmployee = employeeService.save(existingEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}

	// CONTROLLER METHOD TO DELETE THE DATA OF EMPLOYEE BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteById(id);
		return ResponseEntity.ok("Deleted employee id - " + id);
	}

	// CONTROLLER METHOD TO SEARCH EMPLOYEE DATA USING FIRSTNAME
	@GetMapping("/search/{firstName}")
	public ResponseEntity<List<Employee>> searchEmployee(@PathVariable String firstName) {
		List<Employee> employees = employeeService.findByFirstNameContainingIgnoreCase(firstName);
		return ResponseEntity.ok(employees);
	}

	// CONTROLLER METHOD TO SORT THE LIST OF EMPLOYEES BASED ON FIRSTNAME
	@GetMapping("/sort")
	public ResponseEntity<List<Employee>> sortEmployeeList(@RequestParam String order) {
		List<Employee> employees;
		if (order.equalsIgnoreCase("asc")) {
			employees = employeeService.sort(order, "firstName");
		} else {
			employees = employeeService.sort(order, "firstName");
		}
		return ResponseEntity.ok(employees);
	}
}
