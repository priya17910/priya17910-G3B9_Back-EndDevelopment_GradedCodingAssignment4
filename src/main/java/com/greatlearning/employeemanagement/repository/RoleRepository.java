package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.entity.Role;

// ROLE REPOSITORY CLASS EXTENDING JPA REPOSITORY
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
