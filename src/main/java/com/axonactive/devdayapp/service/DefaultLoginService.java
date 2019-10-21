package com.axonactive.devdayapp.service;

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

@Service
public class DefaultLoginService implements LoginService {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void registration(LoginUser loginUser) {

		if (userService.findByUsername(loginUser.getUsername()) != null)
		{
			throw new UserAlreadyExistedException("Error when creating new user. User already existed.");
		}
		Boolean save = userService.save(LoginUser.toUserDTO(loginUser));
		if (!save)	{
			throw new InternalError("Error when creating new user. Cannot save user to database.");
		}
	}

	@Override
	public LoginUser login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

	    authenticationManager.authenticate(usernamePasswordAuthenticationToken);

	    if (usernamePasswordAuthenticationToken.isAuthenticated()) {

	    	SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	        
	        LoginUser loginUser = new LoginUser();
	        loginUser.setUsername(username);
	        loginUser.setPassword(password);
	        return loginUser;
	    }
	    throw new InvalidUsernamePasswordException("User cannot be found. Username: " + username);
		
	}
}
