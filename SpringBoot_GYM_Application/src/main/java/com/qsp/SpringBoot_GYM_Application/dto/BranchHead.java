package com.qsp.SpringBoot_GYM_Application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BranchHead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchheadId;
	private String branchheadName;
	private double branchheadSalary;
	private long branchheadPhone;
	private String branchheadEmail;
	private String branchheadAddress;
	
	public int getBranchheadId() {
		return branchheadId;
	}
	public void setBranchheadId(int branchheadId) {
		this.branchheadId = branchheadId;
	}
	public String getBranchheadName() {
		return branchheadName;
	}
	public void setBranchheadName(String branchheadName) {
		this.branchheadName = branchheadName;
	}
	public double getBranchheadSalary() {
		return branchheadSalary;
	}
	public void setBranchheadSalary(double branchheadSalary) {
		this.branchheadSalary = branchheadSalary;
	}
	public long getBranchheadPhone() {
		return branchheadPhone;
	}
	public void setBranchheadPhone(long branchheadPhone) {
		this.branchheadPhone = branchheadPhone;
	}
	public String getBranchheadEmail() {
		return branchheadEmail;
	}
	public void setBranchheadEmail(String branchheadEmail) {
		this.branchheadEmail = branchheadEmail;
	}
	public String getBranchheadAddress() {
		return branchheadAddress;
	}
	public void setBranchheadAddress(String branchheadAddress) {
		this.branchheadAddress = branchheadAddress;
	}
	
	
	
	

}
