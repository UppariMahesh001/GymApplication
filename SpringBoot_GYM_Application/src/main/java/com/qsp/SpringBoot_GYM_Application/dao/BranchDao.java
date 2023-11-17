package com.qsp.SpringBoot_GYM_Application.dao;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.qsp.SpringBoot_GYM_Application.Repo.BranchRepo;
import com.qsp.SpringBoot_GYM_Application.dto.Address;
import com.qsp.SpringBoot_GYM_Application.dto.Branch;
import com.qsp.SpringBoot_GYM_Application.dto.BranchHead;
import com.qsp.SpringBoot_GYM_Application.dto.Customers;



@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	//save
	
	public Branch save(Branch branch) {
		return branchRepo.save(branch);	
	}

	//deleteById
	
	public Branch deleteById(int id) {
		Optional<Branch> branch = branchRepo.findById(id);
		if (branch.isPresent()) {
			branchRepo.deleteById(id);
			return branch.get();
		} else {
			return null;
		}
		
	}

	//Update
	
	public Branch Update(int id,Branch branch) {
		Branch branch2=branchRepo.findById(id).get();
		branch.setBranchId(id);
		branchRepo.save(branch);
		return branch2;
	}
	
	//FetchById
	
	public Branch FetchById(int branchId) {
		Branch branch=branchRepo.findById(branchId).get();
		return save(branch);
	}

	//FetchAll
	
	public List<Branch> FetchAll() {
		List<Branch>branchs=branchRepo.findAll();
		return branchs;
	}
	
	
//	//addExistingAddressToExBranch
//	
//	public Branch addExistingAddressToExBranch(int branchId,int addressId) {
//		Branch branch =branchRepo.findById(branchId).get();
//		Address address=addressDao.fetchById(addressId);
//		branch.setAddress(address);
//		return save(branch) ;	
//	}
//	//addNewAddressToExistingBranch
//	
//	public Branch addNewAddressToExistingBranch(int branchId,Address newaddressId) {
//		Branch branch=branchRepo.findById(branchId).get();
//		branch.setAddress(newaddressId);
//		return save(branch);
//		
//	}
//      //AddExistingBranchHeadToExistingBranch
//	
//	public Branch AddExistingBranchHeadToExistingBranch(int branchId, int branchHeadId) {
//		Branch branch=branchRepo.findById(branchId).get();
//		BranchHead branchHead=branchHeadDao.FetchById(branchHeadId);
//		branch.setBranchHead(branchHead);
//		return branch;
//		
//	}
//	
//	//AddNewBranchHeadToExistingBranch
//
//	public Branch AddNewBranchHeadToExistingBranch(int branchId, BranchHead BranchHead) {
//		Branch branch=branchRepo.findById(branchId).get();
//		return branch;
//		
//	}
//
//	//AddNewCostomerToExistingBranch
//	
//	public Branch AddNewCostomerToExistingBranch(int branchId, List<Customers> customers) {
//		Branch branch = branchRepo.findById(branchId).get();
//		List<Customers> list = new ArrayList<Customers>();
//		for (Customers customer2 : customers) {
//
//			list.add(customer2);
//		}
//		branch.setCustomers(list);
//		return branchRepo.save(branch);
//	}
//	
	

}
