package com.axonactive.devdayapp.service;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.dto.LoginUser;
import com.axonactive.devdayapp.exception.InvalidUsernamePasswordException;
import com.axonactive.devdayapp.exception.UserAlreadyExistedException;
import com.axonactive.devdayapp.exception.UserNotFoundException;
import com.axonactive.devdayapp.logger.Log;
import com.axonactive.devdayapp.util.Constants;

@Service
public class DefaultLoginService implements LoginService {
	
	private static @Log Logger log;

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void registration(LoginUser loginUser) {
		
		long startTime = System.currentTimeMillis();
		
		if (userService.findByUsername(loginUser.getUsername()) != null) {
			log.error(Constants.ERROR_LOG_MSG, getClass().getName(), 
					"register",
					String.format("User already existed: userName=%s, password=%s", loginUser.getUsername(), loginUser.getPassword()));
			throw new UserAlreadyExistedException("Error when creating new user. User already existed.");
		}
		
		Boolean save = userService.save(LoginUser.toUserDTO(loginUser));
		if (!save) {
			log.error(Constants.ERROR_LOG_MSG, getClass().getName(), 
					"register",
					String.format("Cannot save user to database: userName=%s, password=%s", loginUser.getUsername(), loginUser.getPassword()));
			throw new InternalError("Error when creating new user. Cannot save user to database.");
		}
		log.info(Constants.INFO_LOG_MSG, getClass().getName(), 
				"register", 
				System.currentTimeMillis() - startTime,
				String.format("userName=%s, password=%s", loginUser.getUsername(), loginUser.getPassword()));
	}

	@Override
	public LoginUser login(String username, String password) {
		
		long startTime = System.currentTimeMillis();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (userDetails == null) {
			log.error(Constants.ERROR_LOG_MSG, getClass().getName(), 
					"login",
					String.format("User cannot be found: userName=%s, password=%s", username, password));
			throw new UserNotFoundException("User cannot be found. Username: " + username);
		}
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {

			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			log.info(Constants.INFO_LOG_MSG, getClass().getName(), 
					"login", 
					System.currentTimeMillis() - startTime,
					String.format("userName=%s, password=%s", username, password));
			
			LoginUser loginUser = new LoginUser();
			loginUser.setUsername(username);
			loginUser.setPassword(password);
			return loginUser;
		}
		
		log.error(Constants.ERROR_LOG_MSG, getClass().getName(), "login",
				String.format("Invalid username and/or password: userName=%s, password=%s", username, password));
		throw new InvalidUsernamePasswordException("Username and/or password is not correct. Username: " + username);
	}
}
