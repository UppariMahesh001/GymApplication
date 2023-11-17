package com.qsp.SpringBoot_GYM_Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_GYM_Application.Repo.MembershipRepo;
import com.qsp.SpringBoot_GYM_Application.dto.Branch;
import com.qsp.SpringBoot_GYM_Application.dto.Customers;
import com.qsp.SpringBoot_GYM_Application.dto.Gym;
import com.qsp.SpringBoot_GYM_Application.dto.Membership;

@Repository
public class MemebershipDao {

	@Autowired
	MembershipRepo membershipRepo;
	
	public Membership save(Membership membership) {
		return membershipRepo.save(membership);
	}
	
	public Membership Fetch(int id) {
		Membership membership=membershipRepo.findById(id).get();
		return membership;
	}
	
	public List<Membership> FetchAll() {
		List<Membership>memberships=membershipRepo.findAll();
		return memberships;
	}

	
	public Membership deleteById(int id) {
		Optional<Membership> membership = membershipRepo.findById(id);
		if (membership.isPresent()) {
			membershipRepo.deleteById(id);
			return membership.get();
		} else {
			return null;
		}
		
	}
	
//	public Membership delete(int membershipId) {
//		Optional<Membership> membership = membershipRepo.findById(membershipId);
//		if (membership.isPresent()) {
//			membershipRepo.deleteById(membershipId);
//			return membership.get();
//		} else {
//			return null;
//		}
//	}
	
//	public Membership deleteId(int id) {
//		Membership membership=membershipRepo.findById(id).get();
//		membershipRepo.deleteById(id);
//		return membership;
//		
//	}
	public Membership Update(int id, Membership membership) {
		Membership membership2 =membershipRepo.findById(id).get();
		membership.setMembershipId(id);
		membershipRepo.save(membership);
		return membership2;	
	}

}
