package com.musala.test.drones.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.musala.test.drones.controller.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DispatcherException.class })
	public ResponseEntity<ErrorResponse> handleDispatcherException(DispatcherException exception) {
		log.info(exception.getMessage(), exception);
		ErrorResponse errorResponse = ErrorResponse.builder()
				.timestamp(new Date())
				.errorCode(exception.getErrorCode())
				.message(exception.getMessage()).build();
		return new ResponseEntity<>(errorResponse, exception.getHttpStatusCode());
	}

}
