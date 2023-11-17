package com.qsp.SpringBoot_GYM_Application.dao;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_GYM_Application.Repo.CustomerRep;

import com.qsp.SpringBoot_GYM_Application.dto.Customers;



@Repository
public class CustomerDao {
	@Autowired
	CustomerRep customerRep;
	
	public Customers save(Customers customers) {
		return customerRep.save(customers);
		
	}
	
	//fetchbyid
	
		public Customers FetchById(int customerId) {
			Customers customer=customerRep.findById(customerId).get();
			return customer;
		}
		
		//fetchall
		
		public List<Customers> FetchAll() {
			List<Customers> customers=customerRep.findAll();
			return customers;
		}

	public Customers deleteById(int id) {
		
		Customers customers=customerRep.findById(id).get();
		customers.setCustomerId(id);
		customerRep.deleteById(id);
		return customers;
	}

	public Customers Update(int id, Customers customers) {
		Customers customers2=customerRep.findById(id).get();
		customers.setCustomerId(id);
		customerRep.save(customers);
		return customers2;
	}		
}
