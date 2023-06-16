package com.musala.test.drones.exception;

import org.springframework.http.HttpStatus;

public class DroneModelNotFoundException extends DispatcherException {

	private static final long serialVersionUID = 1L;

	public DroneModelNotFoundException(String errorCode, String message, HttpStatus httpStatusCode) {
		super(errorCode, message, httpStatusCode);
	}

}
