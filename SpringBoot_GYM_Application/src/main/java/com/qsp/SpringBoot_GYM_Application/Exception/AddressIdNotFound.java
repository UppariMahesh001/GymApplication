package com.qsp.SpringBoot_GYM_Application.Exception;

public class AddressIdNotFound extends RuntimeException {

	
private String message="Address Not Found ";
	
	public String getMessage() {
		return message;
	}
	
}
