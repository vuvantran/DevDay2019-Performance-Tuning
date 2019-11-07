package com.axonactive.devdayapp.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg) {
		super(msg);
	}

	public UserNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}
}
