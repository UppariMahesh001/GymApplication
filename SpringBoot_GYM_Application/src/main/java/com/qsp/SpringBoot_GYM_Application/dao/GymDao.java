package com.qsp.SpringBoot_GYM_Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_GYM_Application.Repo.GymRepo;
import com.qsp.SpringBoot_GYM_Application.dto.Gym;

@Repository
public class GymDao {
	
	@Autowired
	GymRepo gymrepo;
	
	public Gym saveGym(Gym gym) {
		return gymrepo.save(gym);	
	}

	public Gym FetchById(int id) {
		Optional<Gym> gym = gymrepo.findById(id);
		if (gym.isPresent()) {
			return gym.get();
		} else {
			return null;
		}
	}

	public List<Gym> FetchAll() {
		List<Gym> gym=gymrepo.findAll();
		return gym;
	}

	public Gym delete(int gymId) {
		Optional<Gym> gym = gymrepo.findById(gymId);
		if (gym.isPresent()) {
			gymrepo.deleteById(gymId);
			return gym.get();
		} else {
			return null;
		}
	}

	public Gym Update(int gymId, Gym gym) {
		Gym gym2 =gymrepo.findById(gymId).get();
		gym.setGymId(gymId);
		gymrepo.save(gym);
		return gym2;
	}
	
	
}
