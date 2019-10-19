package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.dto.LoginUser;
import com.axonactive.devdayapp.dto.UserDto;
import com.axonactive.devdayapp.exception.InvalidUsernamePasswordException;
import com.axonactive.devdayapp.exception.UserAlreadyExistedException;
import com.axonactive.devdayapp.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class DefaultLoginService implements LoginService {
    private static final Logger log = LogManager.getLogger(DefaultLoginService.class);
    
	@Autowired
	private UserService userService;

	@Override
	public void registration(LoginUser loginUser) {
        long startTime = System.currentTimeMillis();
		if (userService.findByUsername(loginUser.getUsername()) != null)
		{
            log.error(Constants.ERROR_LOG_MSG, getClass(),
                "registration", 
                String.format("User already existed: userName=%s, password=%s", loginUser.getUsername(), loginUser.getPassword()));
			throw new UserAlreadyExistedException("Error when creating new user. User already existed.");
		}
		Boolean save = userService.save(LoginUser.toUserDTO(loginUser));
		if (!save)	{
            log.error(Constants.ERROR_LOG_MSG, getClass(),
                "registration", 
                String.format("Cannot save user to database: userName=%s, password=%s", loginUser.getUsername(), loginUser.getPassword()));
			throw new InternalError("Error when creating new user. Cannot save user to database.");
		}
        log.info(Constants.INFO_LOG_MSG, getClass(),
                "registration", 
                System.currentTimeMillis() - startTime,
                String.format("userName=%s, password=%s", loginUser.getUsername(), loginUser.getPassword()));
	}

	@Override
	public LoginUser login(String username, String password) {
		long startTime = System.currentTimeMillis();
		UserDto user = userService.findByUsername(username);
		if (user == null)
		{
            log.error(Constants.ERROR_LOG_MSG, getClass(),
                "login", 
                String.format("User cannot be found: userName=%s, password=%s", username, password));
			throw new UserNotFoundException("User cannot be found. Username: " + username);
		}
		if (!isValidPassword(password, user.getPassword())) {
            log.error(Constants.ERROR_LOG_MSG, getClass(),
                "login", 
                String.format("User cannot be found: userName=%s, password=%s", username, password));
			throw new InvalidUsernamePasswordException("User cannot be found. Username: " + username);
		}

		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(username);
		loginUser.setPassword(password);
        log.info(Constants.INFO_LOG_MSG, getClass(),
                "login", 
                System.currentTimeMillis() - startTime,
                String.format("userName=%s, password=%s", username, password));
		return loginUser;
	}

	private boolean isValidPassword(String inputPassword, String dbPassword) {
		return DigestUtils.md5DigestAsHex(inputPassword.getBytes()).equals(dbPassword);
	}

}
