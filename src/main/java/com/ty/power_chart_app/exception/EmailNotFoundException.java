package com.ty.power_chart_app.exception;

public class EmailNotFoundException extends RuntimeException {

	private String message="Email Not Found";

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public EmailNotFoundException() {
		
	}
	
	public String getMessage() {
		return message;
	}
}
