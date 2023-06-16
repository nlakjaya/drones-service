package com.musala.test.drones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.musala.test.drones.exception.ValidationException;
import com.musala.test.drones.util.Message;

@Service
public class ValidationService {

	public void validateInput(BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
			String errorMessage = String.join(" AND ", errors);
			throw new ValidationException(Message.INVALID_REQUEST.getDescription(), errorMessage,
					HttpStatus.BAD_REQUEST);
		}
	}

}
