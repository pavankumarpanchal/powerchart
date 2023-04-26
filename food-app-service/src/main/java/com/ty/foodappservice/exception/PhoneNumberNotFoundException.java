package com.ty.foodappservice.exception;

public class PhoneNumberNotFoundException extends RuntimeException{
	
	
	private String message;

	public PhoneNumberNotFoundException(String message) {
		super();
		this.message = message;
	}
	public PhoneNumberNotFoundException() {
		super();
		this.message = message;
	}
    @Override
    public String getMessage() {
    	return super.getMessage();
    }
}
