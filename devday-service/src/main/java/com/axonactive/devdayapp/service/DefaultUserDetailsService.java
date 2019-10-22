package com.axonactive.devdayapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.dto.UserDto;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userService.findByUsername(username);
		
		if (userDto != null) {
			return new org.springframework.security.core.userdetails.User(userDto.getUsername(), userDto.getPassword(), new ArrayList<>());
		}
		return null;
	}

}
