package com.qsp.SpringBoot_GYM_Application.Exception;

public class TrainerIdNotFound  extends RuntimeException{
	
private String message="Trainer Not Found ";
	
	public String getMessage() {
		return message;
	}

}
