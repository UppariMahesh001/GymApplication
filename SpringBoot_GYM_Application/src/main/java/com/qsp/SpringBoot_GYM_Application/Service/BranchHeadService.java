package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.SpringBoot_GYM_Application.Exception.AddressIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Exception.BranchIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;

import com.qsp.SpringBoot_GYM_Application.dao.BranchHeadDao;

import com.qsp.SpringBoot_GYM_Application.dto.BranchHead;

@Service
public class BranchHeadService {	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	

	public ResponseEntity<ResponseStructure<BranchHead>> save(BranchHead branchHead) {
		ResponseStructure<BranchHead>responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Inserted");
		responseStructure.setData(branchHeadDao.save(branchHead));
		return  new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> FetchById(int branchHeadId) {
		ResponseStructure<BranchHead>responseStructure=new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully fetched");
		responseStructure.setData(branchHeadDao.FetchById(branchHeadId));
		return  new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> FetchAll(){
		ResponseStructure<BranchHead>responseStructure=new ResponseStructure<BranchHead>();
		List<BranchHead>list=branchHeadDao.FetchAll();
		if(list!=null){
			
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("success fetched All ");
	    responseStructure.setDatas(list);
	    return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			 throw new AddressIdNotFound() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<BranchHead>> Update(int branchHeadId, BranchHead  branchHead){
		ResponseStructure<BranchHead>responseStructur=new ResponseStructure<BranchHead>();
		responseStructur.setStatus(HttpStatus.OK.value());
		responseStructur.setMessage("success update ");
		responseStructur.setData(branchHeadDao.Update(branchHeadId, branchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructur,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<BranchHead>> delete(int id) {
		ResponseStructure<BranchHead>responseStructure=new ResponseStructure<BranchHead>();
		BranchHead branchHead =branchHeadDao.delete(id);
		if(branchHead!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success delete ");
			responseStructure.setData(branchHead);
			return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			throw new BranchIdNotFound();
		}
	}


	
	

}
