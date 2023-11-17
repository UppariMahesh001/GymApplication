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

import com.qsp.SpringBoot_GYM_Application.Service.BranchHeadService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;

import com.qsp.SpringBoot_GYM_Application.dto.BranchHead;


@RestController
public class BranchHeadController {
	@Autowired
	BranchHeadService branchHeadService;
	

	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> savebranch(@RequestBody BranchHead branchHead) {
		return branchHeadService.save(branchHead);
		
	}
	
	@GetMapping("/fetchBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> Fetch(@RequestParam int branchHeadId) {
		return branchHeadService.FetchById(branchHeadId);
	}
	
	@GetMapping("/FetchAllBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> FetchAll(){
	 return branchHeadService.FetchAll();
	}
	
	@PutMapping("/updateBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> UPDATE(@RequestParam int branchHeadId,@RequestBody BranchHead branchHead) {
		return branchHeadService.Update(branchHeadId, branchHead);
	}
	
	@DeleteMapping("/deleteBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> DELETE(@RequestParam int id) {
		return branchHeadService.delete(id);
	}
}
