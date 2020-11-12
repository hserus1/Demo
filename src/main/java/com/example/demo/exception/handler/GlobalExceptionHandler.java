package com.example.demo.exception.handler;

import java.net.SocketTimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.InvalidParameterException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = InvalidParameterException.class)
	public ResponseEntity<Object> handleInvalidParameterException(InvalidParameterException exception) {
		return new ResponseEntity<>(exception.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = SocketTimeoutException.class)
	public ResponseEntity<Object> handleSocketTimeoutException(SocketTimeoutException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.REQUEST_TIMEOUT);
	}
}

