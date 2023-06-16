package com.musala.test.drones.exception;

import org.springframework.http.HttpStatus;

public class DroneNotIdleException extends DispatcherException {

	private static final long serialVersionUID = 1L;

	public DroneNotIdleException(String errorCode, String message, HttpStatus httpStatusCode) {
		super(errorCode, message, httpStatusCode);
	}

}
