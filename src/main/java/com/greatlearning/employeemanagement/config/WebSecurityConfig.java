package com.greatlearning.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeemanagement.service.UserServiceImpl;

// CLASS FOR SPRING SECURITY CONFIGURATION
@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Bean
	public UserDetailsService getDetailsService() {
		return new UserServiceImpl();
	}

	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider getProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(getDetailsService());
		auth.setPasswordEncoder(getEncoder());
		return auth;
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) {
		builder.authenticationProvider(getProvider());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
				.antMatchers("/swagger-ui.html", "/v2/api-docs/**", "/swagger-resources/**", "/webjars/**",
						"/configuration/**")
				.permitAll().antMatchers("/api/roles/**").permitAll().antMatchers("/api/users/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/employees/**").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.DELETE, "/api/employees/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/employees/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/employees/**").hasAuthority("ADMIN").anyRequest().authenticated()
				.and().formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/api/employees", true).permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.permitAll()
				.and().headers()
                .cacheControl().disable().and().httpBasic().and().exceptionHandling();
		;
	}
}
