package com.musala.test.drones.exception;

import org.springframework.http.HttpStatus;

public class DroneNotFoundException extends DispatcherException {

	private static final long serialVersionUID = 1L;

	public DroneNotFoundException(String errorCode, String message, HttpStatus httpStatusCode) {
		super(errorCode, message, httpStatusCode);
	}

}
