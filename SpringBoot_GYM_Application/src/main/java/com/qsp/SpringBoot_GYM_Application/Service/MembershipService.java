package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.qsp.SpringBoot_GYM_Application.Exception.MembershipIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dao.MemebershipDao;

import com.qsp.SpringBoot_GYM_Application.dto.Membership;

@Service
public class MembershipService {

	@Autowired
	MemebershipDao memebershipDao;
	   
	
	public ResponseEntity<ResponseStructure<Membership>> save(Membership membership) {
		ResponseStructure<Membership> responseStructure=new ResponseStructure<Membership>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success inserted");
		responseStructure.setData(memebershipDao.save(membership));
		return new ResponseEntity<ResponseStructure<Membership>>(responseStructure,HttpStatus.CREATED);
		
		
	}
	
	public ResponseEntity<ResponseStructure<Membership>> Fetch(int id) {
		ResponseStructure<Membership>responseStructure=new ResponseStructure<Membership>();
		Membership membership=memebershipDao.Fetch(id);
		if(membership!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success fetched ");
			responseStructure.setData(memebershipDao.Fetch(id));
			return new ResponseEntity<ResponseStructure<Membership>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new MembershipIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Membership>> FetchAll(){
		ResponseStructure<Membership>responseStructure=new ResponseStructure<Membership>();
		List<Membership>list=memebershipDao.FetchAll();
		if(list!=null){
			
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("success fetched All ");
	    responseStructure.setDatas(list);
	    return new ResponseEntity<ResponseStructure<Membership>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			 throw new MembershipIdNotFound() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Membership>>delete(int id){
		ResponseStructure<Membership>responseStructure=new ResponseStructure<Membership>();
		Membership membership  =memebershipDao.deleteById(id);
		if(membership!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success delete ");
			responseStructure.setData(membership);
			return new ResponseEntity<ResponseStructure<Membership>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			throw new MembershipIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Membership>> Update(int membershipId, Membership membership ){
		ResponseStructure<Membership>responseStructur=new ResponseStructure<Membership>();
		responseStructur.setStatus(HttpStatus.OK.value());
		responseStructur.setMessage("success update ");
		responseStructur.setData(memebershipDao.Update(membershipId, membership));
		return new ResponseEntity<ResponseStructure<Membership>>(responseStructur,HttpStatus.FOUND);
	}
	


}
