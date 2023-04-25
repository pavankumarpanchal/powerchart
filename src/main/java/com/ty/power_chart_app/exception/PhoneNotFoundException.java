package com.ty.power_chart_app.exception;

public class PhoneNotFoundException extends RuntimeException {

	private String message="Phone number not found";

	public PhoneNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public PhoneNotFoundException() {
		
	}
	
	public String getMessage() {
		return message;
	}
}

