package com.axonactive.devdayapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.axonactive.devdayapp.dto.LoginUser;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.exception.InvalidUsernamePasswordException;
import com.axonactive.devdayapp.exception.UserAlreadyExistedException;
import com.axonactive.devdayapp.exception.UserNotFoundException;

@Service
public class DefaultLoginService implements LoginService {

	@Autowired
	private UserService userService;

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
		
		UserDto user = userService.findByUsername(username);
		if (user == null)
		{
			throw new UserNotFoundException("User cannot be found. Username: " + username);
		}
		if (!isValidPassword(password, user.getPassword())) {
			throw new InvalidUsernamePasswordException("User cannot be found. Username: " + username);
		}

		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(username);
		loginUser.setPassword(password);
		return loginUser;
	}

	private boolean isValidPassword(String inputPassword, String dbPassword) {
		return DigestUtils.md5DigestAsHex(inputPassword.getBytes()).equals(dbPassword);
	}

}
