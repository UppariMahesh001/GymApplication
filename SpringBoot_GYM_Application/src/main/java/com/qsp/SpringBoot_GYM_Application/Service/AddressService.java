package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.SpringBoot_GYM_Application.Exception.AddressIdNotFound;

import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dao.AddressDao;

import com.qsp.SpringBoot_GYM_Application.dto.Address;


@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	

	public ResponseEntity<ResponseStructure<Address>> SaveAddress(Address address) {
		ResponseStructure<Address>responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully Inserted");
		responseStructure.setData(addressDao.insertAddress(address));
		return  new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Address>> FetchById(int addressId) {
		ResponseStructure<Address>responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully fetched");
		responseStructure.setData(addressDao.fetchById(addressId));
		return  new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Address>> FetchAll(){
		ResponseStructure<Address>responseStructure=new ResponseStructure<Address>();
		List<Address>list=addressDao.FetchAll();
		if(list!=null){
			
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("success fetched All ");
	    responseStructure.setDatas(list);
	    return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			 throw new AddressIdNotFound() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>>deleteaddress(int id){
		ResponseStructure<Address>responseStructure=new ResponseStructure<Address>();
		Address address =addressDao.DeleteById(id);
		if(address!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success delete ");
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> Update(int addressId, Address address){
		ResponseStructure<Address>responseStructur=new ResponseStructure<Address>();
		responseStructur.setStatus(HttpStatus.OK.value());
		responseStructur.setMessage("success update ");
		responseStructur.setData(addressDao.Update(addressId, address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructur,HttpStatus.FOUND);
	}
	
	
	

	
	

}
