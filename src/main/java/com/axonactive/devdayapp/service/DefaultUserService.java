package com.axonactive.devdayapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import com.axonactive.devdayapp.domain.User;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.repo.UserRepository;

@Service
public class DefaultUserService implements UserService {

	@Autowired
    private UserRepository userRepository;

	@Override
	public Boolean save(UserDto userDto) {
		
		Assert.notNull(userDto.getUsername(), "Username cannot be empty!");
		Assert.notNull(userDto.getPassword(), "Password cannot be empty!");
		
		userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
		return userRepository.save(UserDto.toEntity(userDto)) != null;
	}

	@Override
	public UserDto findByUsername(String username) {
		
		Assert.notNull(username, "Username cannot be empty!");
		
		User user = userRepository.findByUsername(username);
		return UserDto.fromEntity(user);
	}
}

