package com.qsp.SpringBoot_GYM_Application.Exception;

public class CustomerIdNotFound  extends RuntimeException{
	
private String message="Customer Not Found ";
	
	public String getMessage() {
		return message;
	}

}
