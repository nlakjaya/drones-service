package com.musala.test.drones.exception;

import org.springframework.http.HttpStatus;

public class DroneBatteryLowException extends DispatcherException {

	private static final long serialVersionUID = 1L;

	public DroneBatteryLowException(String errorCode, String message, HttpStatus httpStatusCode) {
		super(errorCode, message, httpStatusCode);
	}

}
