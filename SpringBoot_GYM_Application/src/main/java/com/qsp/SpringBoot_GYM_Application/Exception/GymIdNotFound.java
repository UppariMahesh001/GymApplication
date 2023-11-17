package com.qsp.SpringBoot_GYM_Application.Exception;

public class GymIdNotFound  extends RuntimeException{
	
	private String message="Gym Not Found ";
	
	public String getMessage() {
		return message;
	}
	
	

}
