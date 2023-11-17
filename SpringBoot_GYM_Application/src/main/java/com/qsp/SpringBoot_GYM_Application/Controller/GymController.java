package com.qsp.SpringBoot_GYM_Application.Controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.SpringBoot_GYM_Application.Service.GymService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dto.Gym;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GymController {
  @Autowired 
  GymService gymService;
  
  //........inserting......
  

@ApiOperation(value = "save gym",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "Employee saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })
  
  @PostMapping("/saveGym")
  public ResponseEntity<ResponseStructure<Gym>> saveGym(@Valid  @RequestBody Gym gym) {
	return gymService.saveGym(gym);
	  
  }
  
  @GetMapping("/fetch")
  public ResponseEntity<ResponseStructure<Gym>>FetchById(@RequestParam int id){
	  return gymService.FetchById(id);
  }
  
//FetchAll
	
	
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<Gym>> gymfetchall() {
		return gymService.FetchAll();
	}
	
	
	//delete
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Gym>> deletebyidgym(@RequestParam int id) {
		return gymService.deletegym(id);
	}
	
	//update
	
	@PutMapping("/updateGym")
	public ResponseEntity<ResponseStructure<Gym>> UPDATE(@RequestParam int gymId,@RequestBody Gym gym) {
		return gymService.Update(gymId, gym);
		
	}
  
  
}
