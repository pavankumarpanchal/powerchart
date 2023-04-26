package com.ty.foodappservice.exception;

public class IdNotFoundException extends RuntimeException{
	
    private String message;
    
    public IdNotFoundException() {
		super();
		this.message = message;
	}

    

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
   public String getMessage()
   {
  	 return message;

   }

}
