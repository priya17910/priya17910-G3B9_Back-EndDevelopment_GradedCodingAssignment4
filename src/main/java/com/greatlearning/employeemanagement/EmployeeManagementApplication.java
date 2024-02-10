package com.greatlearning.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// CLASS WITH MAIN METHOD + ENABLING SWAGGER UI
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.greatlearning.employeemanagement")
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
