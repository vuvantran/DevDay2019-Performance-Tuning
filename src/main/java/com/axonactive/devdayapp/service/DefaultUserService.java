package com.axonactive.devdayapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.axonactive.devdayapp.domain.User;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.repo.UserRepository;

@Service
public class DefaultUserService implements UserService {

	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder md5PasswordEncoder;

	@Override
	public Boolean save(UserDto userDto) {
		
		Assert.notNull(userDto.getUsername(), "Username cannot be empty!");
		Assert.notNull(userDto.getPassword(), "Password cannot be empty!");
		
		userDto.setPassword(md5PasswordEncoder.encode(userDto.getPassword()));
		return userRepository.save(UserDto.toEntity(userDto)) != null;
	}

	@Override
	public UserDto findByUsername(String username) {
		
		Assert.notNull(username, "Username cannot be empty!");
		
		User user = userRepository.findByUsername(username);
		return UserDto.fromEntity(user);
	}
}

