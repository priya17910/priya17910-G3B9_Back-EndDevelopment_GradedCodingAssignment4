package com.greatlearning.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.repository.RoleRepository;

// ROLE SERVICE CLASS IMPLEMENTING THE METHODS OF ROLE SERVICE INTERFACE
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

}
