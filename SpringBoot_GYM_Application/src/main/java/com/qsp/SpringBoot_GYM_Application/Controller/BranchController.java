package com.qsp.SpringBoot_GYM_Application.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringBoot_GYM_Application.Service.BranchService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;

import com.qsp.SpringBoot_GYM_Application.dto.Address;
import com.qsp.SpringBoot_GYM_Application.dto.Branch;
import com.qsp.SpringBoot_GYM_Application.dto.Customers;


@RestController
public class BranchController {
	@Autowired
	BranchService branchService;
	

	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> savebranch(@RequestBody Branch branch) {
		return branchService.SaveBranch(branch);
		
	}
	
	@GetMapping("/fetchBranch")
	public ResponseStructure<Branch> Fetch(@RequestParam int branchId) {
		return branchService.fetchbyid(branchId);
	}
	
	@GetMapping("/FetchAllBranch")
	public ResponseEntity<ResponseStructure<Branch>> FetchAll(){
	 return branchService.FetchAll();
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> UPDATE(@RequestParam int branchId,@RequestBody Branch branch) {
		return branchService.Update(branchId, branch);
	}
	
	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> DELETE(@RequestParam int id) {
		return branchService.deletebranch(id);
	}
	
//	@PutMapping("/addexistingaddresstoexistingBranch")
//	public Branch addexistingaddresstoexistingBranch(@RequestParam int branchId ,@RequestParam int addressId) {
//		return branchService.AddExistingAddressToBranch(branchId, addressId);
//	}
//	
//	@PutMapping("/addneweaddresstoexistingbranch")
//	public Branch ADDNEWAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address newAddress) {
//		return branchService.addneweaddresstoexistingbranch(branchId, newAddress);
//	}
//	
//	@PutMapping("/addExistingBranchHeadToExistingBranch")
//	public Branch ADDEXISTINGBRANCHhEADToexistingBranch(@RequestParam int branchId,@RequestParam int branchHeadId) {
//		return branchService.addexistingbranchheadToexistingbranch(branchId, branchHeadId);
//	}
//	
//	@PutMapping("/addnewbranchHeadToExistingBranch")
//	public Branch ADDNEWBranchHeadToExistingBranch(@RequestParam int branchId,com.qsp.SpringBoot_GYM_Application.dto.BranchHead newBranchHead) {
//		return branchService.addnewbranchHeadToExistingBranch(branchId, newBranchHead);
//	}
//
//	
//	@PutMapping("/addNewcostomerToExistingbra")
//	public Branch addNewcostomertoexistingbranch(@RequestParam int branchId,@RequestBody List<Customers>customers) {
//		return branchService.addNewcostomerToExistingBranchu(branchId, customers);
//	}
//	
	 
	
}
