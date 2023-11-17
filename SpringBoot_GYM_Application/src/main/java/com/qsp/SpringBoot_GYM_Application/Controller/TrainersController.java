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

import com.qsp.SpringBoot_GYM_Application.Service.TrainersService;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;

import com.qsp.SpringBoot_GYM_Application.dto.Trainers;

@RestController
public class TrainersController {
	
	@Autowired
	TrainersService trainersService;
	
	@PostMapping("/saveTrainers")
	public ResponseEntity<ResponseStructure<Trainers>> save(@RequestBody Trainers trainers) {
		return trainersService.save(trainers);	
	}

	@DeleteMapping("/deleteTrainers")
	public ResponseEntity<ResponseStructure<Trainers>> delete(@RequestParam int id) {
		return trainersService.delete(id);	
	}
	  @PutMapping("/UpdateTrainers")
	  public ResponseEntity<ResponseStructure<Trainers>> update( @RequestParam int id,@RequestBody Trainers trainers) {
		return trainersService.Update(id, trainers);
		  
	  }
	 @GetMapping("/FetchIdTrainers")
	 public ResponseEntity<ResponseStructure<Trainers>>FetchById(@RequestParam int trainersid){
	 return trainersService.FetchById(trainersid);
	  }
	  
	//FetchAll
		@GetMapping("/FetchAllTrainers")
		public ResponseEntity<ResponseStructure<Trainers>> fetchall() {
			return trainersService.FetchAll();
		}
	
}
