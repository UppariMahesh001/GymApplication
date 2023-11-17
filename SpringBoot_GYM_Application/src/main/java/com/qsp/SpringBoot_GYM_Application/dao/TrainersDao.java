package com.qsp.SpringBoot_GYM_Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_GYM_Application.Repo.TrainersRepo;
import com.qsp.SpringBoot_GYM_Application.dto.Customers;
import com.qsp.SpringBoot_GYM_Application.dto.Membership;
import com.qsp.SpringBoot_GYM_Application.dto.Trainers;

@Repository
public class TrainersDao {

	@Autowired
	TrainersRepo trainersRepo;
	
	public Trainers save(Trainers trainers) {
		return trainersRepo.save(trainers);
	}

	public Trainers deleteById(int id) {
		Optional<Trainers> trainers = trainersRepo.findById(id);
		if (trainers.isPresent()) {
			trainersRepo.deleteById(id);
			return trainers.get();
		} else {
			return null;
		}
		
	}

	
//	public Trainers deleteBId(int id) {
//		Trainers trainers=trainersRepo.findById(id).get();
//		trainersRepo.deleteById(id);
//		return trainers;
//	}

	public Trainers update(int id, Trainers trainers) {
		Trainers trainers2=trainersRepo.findById(id).get();
		trainers.setTrainerId(id);
		trainersRepo.save(trainers);
		return trainers2;	
		
	}
	
	public List<Trainers> FetchAll() {
		List<Trainers> trainers=trainersRepo.findAll();
		return trainers;
	}
	
	public Trainers FetchById(int trainersId) {
		Trainers trainers=trainersRepo.findById(trainersId).get();
		return trainers;
	}


}
