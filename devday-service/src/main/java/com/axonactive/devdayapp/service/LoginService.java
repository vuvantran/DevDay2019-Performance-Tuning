package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.dto.LoginUser;

public interface LoginService {
	
	void registration(LoginUser loginUser);

	LoginUser login(String username, String password);
}
