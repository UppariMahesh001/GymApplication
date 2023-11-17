package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.qsp.SpringBoot_GYM_Application.Exception.TrainerIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dao.TrainersDao;

import com.qsp.SpringBoot_GYM_Application.dto.Trainers;

@Service
public class TrainersService {
	@Autowired
	TrainersDao trainersDao;
	

	public ResponseEntity<ResponseStructure<Trainers>> save(Trainers trainers ) {
		ResponseStructure<Trainers> responseStructure=new ResponseStructure<Trainers>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("success inserted");
		responseStructure.setData(trainersDao.save(trainers));
		return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.CREATED);
		
		
	}
	
	public ResponseEntity<ResponseStructure<Trainers>> FetchById(int id) {
		ResponseStructure<Trainers>responseStructure=new ResponseStructure<Trainers>();
		Trainers trainers=trainersDao.FetchById(id);
		if(trainers!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success fetched ");
			responseStructure.setData(trainersDao.FetchById(id));
			return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new TrainerIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Trainers>> FetchAll(){
		ResponseStructure<Trainers>responseStructure=new ResponseStructure<Trainers>();
		List<Trainers>list=trainersDao.FetchAll();
		if(list!=null){
			
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("success fetched All ");
	    responseStructure.setDatas(list);
	    return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new TrainerIdNotFound() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Trainers>>delete(int id){
		ResponseStructure<Trainers>responseStructure=new ResponseStructure<Trainers>();
		Trainers trainers  =trainersDao.deleteById(id);
		if(trainers!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success delete ");
			responseStructure.setData(trainers);
			return new ResponseEntity<ResponseStructure<Trainers>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			throw new TrainerIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Trainers>> Update(int trainersId, Trainers trainers ){
		ResponseStructure<Trainers>responseStructur=new ResponseStructure<Trainers>();
		responseStructur.setStatus(HttpStatus.OK.value());
		responseStructur.setMessage("success update ");
		responseStructur.setData(trainersDao.update(trainersId, trainers));
		return new ResponseEntity<ResponseStructure<Trainers>>(responseStructur,HttpStatus.FOUND);
	}
	

}
