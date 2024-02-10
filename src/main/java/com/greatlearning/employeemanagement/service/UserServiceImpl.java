package com.greatlearning.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.config.WebSecurityConfig;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.repository.UserRepository;
import com.greatlearning.employeemanagement.security.UserSecurityLayer;

// USER SERVICE CLASS IMPLEMENTING THE METHODS OF USER SERVICE INTERFACE
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	WebSecurityConfig webSecurityConfig;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSecurityLayer(user);
	}

	@Override
	public User addUser(User user) {
		user.setPassword(webSecurityConfig.getEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}

}
