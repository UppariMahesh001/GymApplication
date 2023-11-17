package com.qsp.SpringBoot_GYM_Application.Exception;

public class BranchHeadIdNotFound  extends RuntimeException {
	
private String message="BranchHead Not Found ";
	
	public String getMessage() {
		return message;
	}
}
