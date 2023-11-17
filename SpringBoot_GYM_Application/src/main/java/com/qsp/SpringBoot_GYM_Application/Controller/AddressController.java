package com.qsp.SpringBoot_GYM_Application.Controller;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringBoot_GYM_Application.Service.AddressService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dto.Address;
import com.qsp.SpringBoot_GYM_Application.dto.Branch;


@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	

	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.SaveAddress(address);
	}
	
	@GetMapping("/fetchbyid")
	public ResponseEntity<ResponseStructure<Address>> fetchbyid(@RequestParam int addressId) {
		return addressService.FetchById(addressId);
		
	}
	
	@GetMapping("/addressFetchAll")
	public ResponseEntity<ResponseStructure<Address>> FindAll(){
		return addressService.FetchAll();
	}
	
	@DeleteMapping("/deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> DeleteById(@RequestParam int addressId) {
		return addressService.deleteaddress(addressId);
	}
	

	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> UPDATE(@RequestParam int id,@RequestBody Address address) {
		return addressService.Update(id, address);
	}
	
	
}
