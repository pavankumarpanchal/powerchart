package com.ty.foodappservice.exception;

public class EmailNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;

	}

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}
	public EmailNotFoundException() {
		super();
		this.message = message;
	}
}
