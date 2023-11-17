package com.qsp.SpringBoot_GYM_Application.Exception;

public class MembershipIdNotFound  extends RuntimeException{
	
private String message="Membership Not Found ";
	
	public String getMessage() {
		return message;
	}
	

}
