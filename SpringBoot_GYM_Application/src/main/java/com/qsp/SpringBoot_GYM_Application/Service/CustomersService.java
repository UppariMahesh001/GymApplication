package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.qsp.SpringBoot_GYM_Application.Exception.CustomerIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dao.CustomerDao;

import com.qsp.SpringBoot_GYM_Application.dto.Customers;


@Service
public class CustomersService {
	@Autowired
	CustomerDao customerDao;
	
	public ResponseStructure<Customers> saveCustomer(Customers customers) {
		ResponseStructure<Customers>respoceStructure=new ResponseStructure<Customers>();
		respoceStructure.setStatus(HttpStatus.CREATED.value());
		respoceStructure.setMessage("successfully inserted");
		respoceStructure.setData(customerDao.save(customers));
		return respoceStructure;
	}
	
	
	public ResponseStructure<Customers> fetchbyid(int customersId) {
		ResponseStructure<Customers>respoceStructure=new ResponseStructure<Customers>();
		respoceStructure.setStatus(HttpStatus.FOUND.value());
		respoceStructure.setMessage("successfully fetched");
		respoceStructure.setData(customerDao.FetchById(customersId));
		return respoceStructure;
	}

	public ResponseEntity<ResponseStructure<Customers>> FetchAll(){
		ResponseStructure<Customers>responseStructure=new ResponseStructure<Customers>();
		List<Customers>list=customerDao.FetchAll();
		if(list!=null){
			
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("success fetched All ");
	    responseStructure.setDatas(list);
	    return new ResponseEntity<ResponseStructure<Customers>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			 throw new CustomerIdNotFound() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Customers>> Update(int customerId, Customers  customers){
		ResponseStructure<Customers>responseStructur=new ResponseStructure<Customers>();
		responseStructur.setStatus(HttpStatus.OK.value());
		responseStructur.setMessage("success update ");
		responseStructur.setData(customerDao.Update(customerId, customers));
		return new ResponseEntity<ResponseStructure<Customers>>(responseStructur,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Customers>> deleteById(int id) {
		ResponseStructure<Customers>responseStructure=new ResponseStructure<Customers>();
		Customers customers =customerDao.deleteById(id);
		if(customers!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success delete ");
			responseStructure.setData(customers);
			return new ResponseEntity<ResponseStructure<Customers>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			throw new CustomerIdNotFound();
		}
	}

}
