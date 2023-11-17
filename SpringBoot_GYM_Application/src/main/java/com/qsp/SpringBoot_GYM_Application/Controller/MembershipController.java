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

import com.qsp.SpringBoot_GYM_Application.Service.MembershipService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dto.Membership;

@RestController
public class MembershipController {
	@Autowired
	MembershipService membershipService;
	
	@PostMapping("/saveMembership")
	public ResponseEntity<ResponseStructure<Membership>> save(@RequestBody  Membership membership) {
		return membershipService.save(membership);	
	}
	
	@DeleteMapping("/Deletemembership")
	public ResponseEntity<ResponseStructure<Membership>> deleteById(@RequestParam int id) {
		return membershipService.delete(id);	
	}
	
	@PutMapping("/UpdateMembership")
	public ResponseEntity<ResponseStructure<Membership>> Update(@RequestParam int id ,@RequestBody Membership membership) {
		return membershipService.Update(id, membership);
		
	}
	
	@GetMapping("/FetchIdMembership")
	 public ResponseEntity<ResponseStructure<Membership>> Fetch(@RequestParam int id){
	 return membershipService.Fetch(id);
	 }
	  
	//FetchAll	
		@GetMapping("/FetchAllMembership")
		public ResponseEntity<ResponseStructure<Membership>>fetchall() {
			return membershipService.FetchAll();
		}

}
