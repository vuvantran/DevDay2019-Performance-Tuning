package com.axonactive.devdayapp.service;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.domain.User;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.logger.Log;
import com.axonactive.devdayapp.repo.UserRepository;

@Service
public class DefaultUserService implements UserService {
	
    private static @Log Logger log;
    
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder md5PasswordEncoder;

	@Override
	public Boolean save(UserDto userDto) {
		
		long startTime = System.currentTimeMillis();
		
		Assert.notNull(userDto.getUsername(), "Username cannot be empty!");
		Assert.notNull(userDto.getPassword(), "Password cannot be empty!");
		
		userDto.setPassword(md5PasswordEncoder.encode(userDto.getPassword()));
		User savedUser = userRepository.save(UserDto.toEntity(userDto));
		
		log.info(Constants.INFO_LOG_MSG, getClass().getName(),
				"save", 
				System.currentTimeMillis() - startTime,
				String.format("userName=%s, password=%s", userDto.getUsername(), userDto.getPassword()));
		
		return savedUser != null;
	}

	@Override
	public UserDto findByUsername(String username) {
		
		long startTime = System.currentTimeMillis();
		
		Assert.notNull(username, "Username cannot be empty!");
		User user = userRepository.findByUsername(username);
		
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "findByUsername", 
                System.currentTimeMillis() - startTime,
                String.format("userName=%s", username));
        
		return UserDto.fromEntity(user);
	}
}

