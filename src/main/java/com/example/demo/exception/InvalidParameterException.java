package com.example.demo.exception;

public class InvalidParameterException extends Exception{

	private String errorMessage;
	
	public InvalidParameterException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
