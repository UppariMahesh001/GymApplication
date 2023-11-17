package com.qsp.SpringBoot_GYM_Application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.SpringBoot_GYM_Application.Repo.BranchHeadRep;

import com.qsp.SpringBoot_GYM_Application.dto.BranchHead;

@Repository
public class BranchHeadDao {
	
	@Autowired
	BranchHeadRep branchHeadRep;
	
	public BranchHead save(BranchHead branchHead) {
		return branchHeadRep.save(branchHead);	
	}

	public BranchHead delete(int id) {
		BranchHead branchHead=branchHeadRep.findById(id).get();
		branchHeadRep.deleteById(id);
		return branchHead;
	}

	public BranchHead Update(int id,BranchHead branchHead) {
		BranchHead branchHead2=branchHeadRep.findById(id).get();
		branchHead.setBranchheadId(id);
		branchHeadRep.save(branchHead);
		return branchHead2;
	}

	public BranchHead FetchById(int branchHeadId) {
		BranchHead branchHead=branchHeadRep.findById(branchHeadId).get();
		return branchHead;
	}

	public List<BranchHead> FetchAll() {
		List<BranchHead>branchHead=branchHeadRep.findAll();
		return branchHead;
		
	}


	

}
