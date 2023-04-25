package com.ty.power_chart_app.exception;

public class IdNotFoundException extends RuntimeException{

	private String message = "ID Not Found";
	
	public IdNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
