package com.qsp.SpringBoot_GYM_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.SpringBoot_GYM_Application.Exception.BranchIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Exception.GymIdNotFound;
import com.qsp.SpringBoot_GYM_Application.Util.ResponseStructure;
import com.qsp.SpringBoot_GYM_Application.dao.BranchDao;
import com.qsp.SpringBoot_GYM_Application.dto.Address;
import com.qsp.SpringBoot_GYM_Application.dto.Branch;
import com.qsp.SpringBoot_GYM_Application.dto.BranchHead;
import com.qsp.SpringBoot_GYM_Application.dto.Customers;


@Service
public class BranchService {
	
	@Autowired
	BranchDao branchDao;

	//insert
		public ResponseStructure<Branch> SaveBranch(Branch branch) {
			ResponseStructure<Branch>respoceStructure=new ResponseStructure<Branch>();
			respoceStructure.setStatus(HttpStatus.CREATED.value());
			respoceStructure.setMessage("successfully inserted");
			 respoceStructure.setData(branchDao.save(branch));
			return respoceStructure;
		}
		
		//fetch by id
		
		public ResponseStructure<Branch> fetchbyid(int branchId) {
			ResponseStructure<Branch>respoceStructure=new ResponseStructure<Branch>();
			respoceStructure.setStatus(HttpStatus.FOUND.value());
			respoceStructure.setMessage("successfully fetched");
			 respoceStructure.setData(branchDao.FetchById(branchId));
			return respoceStructure;
		}
		
		//fetch all
		
		public ResponseEntity<ResponseStructure<Branch>> FetchAll(){
			ResponseStructure<Branch>responseStructure=new ResponseStructure<Branch>();
			List<Branch>list=branchDao.FetchAll();
			if(list!=null){
				
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("success fetched All ");
		    responseStructure.setDatas(list);
		    return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
			}
			else {
				 throw new BranchIdNotFound() ;
			}
		}
		
		//Delete Branch
		
		public ResponseEntity<ResponseStructure<Branch>>deletebranch(int id){
			ResponseStructure<Branch>responseStructure=new ResponseStructure<Branch>();
			Branch branch =branchDao.deleteById(id);
			if(branch!=null) {
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("success delete ");
				responseStructure.setData(branch);
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);	
			}
			else {
				throw new GymIdNotFound();
			}
		}
		
		//Update Branch
		
		public ResponseEntity<ResponseStructure<Branch>> Update(int branchId, Branch branch){
			ResponseStructure<Branch>responseStructur=new ResponseStructure<Branch>();
			responseStructur.setStatus(HttpStatus.OK.value());
			responseStructur.setMessage("success update ");
			responseStructur.setData(branchDao.Update(branchId, branch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructur,HttpStatus.FOUND);
		}
		
		
//		public Branch AddExistingAddressToBranch(int branchId,int addressId) {
//			return branchDao.addExistingAddressToExBranch(branchId, addressId);
//		}
//		
//		public Branch addneweaddresstoexistingbranch(int branchId,Address newAddress) {
//			return branchDao.addNewAddressToExistingBranch(branchId, newAddress);
//		}
//		
//		
//		public Branch addexistingbranchheadToexistingbranch(int branchId,int branchHeadId) {
//			return branchDao.AddExistingBranchHeadToExistingBranch(branchId, branchHeadId);
//		}
//		
//		public Branch addnewbranchHeadToExistingBranch(int branchId,BranchHead newBranchHead) {
//			return branchDao.AddNewBranchHeadToExistingBranch(branchId, newBranchHead);
//		}
//		
//		public  Branch addNewcostomerToExistingBranchu(int branchId,List<Customers>customers) {
//			return branchDao.AddNewCostomerToExistingBranch(branchId, customers);
//		}
//		
	
}
