
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


import com.qsp.SpringBoot_GYM_Application.Service.CustomersService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dto.Customers;



@RestController
public class CustomerController {
	
	@Autowired
	CustomersService customersService;
	
	@PostMapping("/saveCustomer")
	public ResponseStructure<Customers> SaveCustomer(@RequestBody Customers customer) {
		return customersService.saveCustomer(customer);
	}
	
	@GetMapping("/fetchByIdCustomer")
	public ResponseStructure<Customers> FetchById(@RequestParam int customersId) {
		return customersService.fetchbyid(customersId);
	}
	
	
	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<Customers>> FetchALL(){
		return customersService.FetchAll();
	}
	
	@DeleteMapping("/deletebyid")
	public ResponseEntity<ResponseStructure<Customers>> DeleteBId(@RequestParam int id) {
		return customersService.deleteById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Customers>> Udate(@RequestParam int customersId,@RequestBody Customers customers) {
		return customersService.Update(customersId, customers);
		
	}
}
