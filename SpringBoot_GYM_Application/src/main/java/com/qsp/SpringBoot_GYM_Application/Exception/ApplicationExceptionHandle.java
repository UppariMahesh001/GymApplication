package com.qsp.SpringBoot_GYM_Application.Exception;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandle  extends ResponseEntityExceptionHandler{
	
	@Override                 
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new HashMap<>();
		for (ObjectError error : errors) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
    
	@ExceptionHandler(GymIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> gymidnotfound(GymIdNotFound gymidnotfound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found ");
		responseStructure.setData(gymidnotfound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);	
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchidnotfound(BranchIdNotFound branchIdNotFound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);	
	}
	
	@ExceptionHandler(BranchHeadIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchHeadidnotfound(BranchHeadIdNotFound branchHeadIdNotFound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(branchHeadIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);	
	}
	
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customeridnotfound(CustomerIdNotFound customerIdNotFound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);	
	}
	
	@ExceptionHandler(MembershipIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> membershipidnotfound(MembershipIdNotFound membershipIdNotFound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(membershipIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);	
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressidnotfound(AddressIdNotFound addressIdNotFound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);	
	}
	
	@ExceptionHandler(TrainerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> traineridnotfound(TrainerIdNotFound trainerIdNotFound){
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(trainerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);	
	}
}
