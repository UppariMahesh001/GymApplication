package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.SpringBoot_GYM_Application.Exception.GymIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dao.GymDao;
import com.qsp.SpringBoot_GYM_Application.dto.Gym;


@Service
public class GymService {
	
	@Autowired
	GymDao gymDao;
	
	
	public ResponseEntity<ResponseStructure<Gym>> saveGym(Gym gym) {
		ResponseStructure<Gym> responseStructure=new ResponseStructure<Gym>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success inserted");
		responseStructure.setData(gymDao.saveGym(gym));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.CREATED);
		
		
	}
	
	public ResponseEntity<ResponseStructure<Gym>> FetchById(int id) {
		ResponseStructure<Gym>responseStructure=new ResponseStructure<Gym>();
		Gym gym=gymDao.FetchById(id);
		if(gym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success fetched ");
			responseStructure.setData(gymDao.FetchById(id));
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new GymIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Gym>> FetchAll(){
		ResponseStructure<Gym>responseStructure=new ResponseStructure<Gym>();
		List<Gym>list=gymDao.FetchAll();
		if(list!=null){
			
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("success fetched All ");
	    responseStructure.setDatas(list);
	    return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			 throw new GymIdNotFound() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Gym>>deletegym(int id){
		ResponseStructure<Gym>responseStructure=new ResponseStructure<Gym>();
		Gym gym =gymDao.delete(id);
		if(gym!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success delete ");
			responseStructure.setData(gym);
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			throw new GymIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Gym>> Update(int gymId, Gym gym){
		ResponseStructure<Gym>responseStructur=new ResponseStructure<Gym>();
		responseStructur.setStatus(HttpStatus.OK.value());
		responseStructur.setMessage("success update ");
		responseStructur.setData(gymDao.Update(gymId, gym));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructur,HttpStatus.FOUND);
	}
	

}
