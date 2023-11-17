package com.qsp.SpringBoot_GYM_Application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_GYM_Application.Repo.AddressRepo;
import com.qsp.SpringBoot_GYM_Application.dto.Address;


@Repository
public class AddressDao {
	
	@Autowired
	AddressRepo addressrepo;
	
	

	public Address insertAddress(Address address) {
		return addressrepo.save(address);
	}
	
	public Address fetchById(int addressId) {
		Address address=addressrepo.findById(addressId).get();
		return address;
	}
	
	public List<Address> FetchAll(){
		List<Address> addresses=addressrepo.findAll();
		return addresses;
	}
	
	public Address DeleteById(int addressId) {
		Address address=addressrepo.findById(addressId).get();
		addressrepo.deleteById(addressId);
		return address;
	}

	public Address Update(int addressId, Address address) {
		Address address2 =addressrepo.findById(addressId).get();
		address.setAddressId(addressId);
		addressrepo.save(address);
		return address2;
	}
	
}
