package com.stackroute.JwtService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.Repository.AuthenticationServiceRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

@Autowired
AuthenticationServiceRepository repository;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	AuthenticationServiceDto user = repository.findByUserName(username);
	return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
			new ArrayList<>());
} 
}
