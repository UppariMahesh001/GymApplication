package com.qsp.SpringBoot_GYM_Application.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;





@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int branchId;
	private String branchName;
	private long branchPhone;
	private String branchEmail;
	private String branchTimings;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
    @OneToOne(cascade = CascadeType.ALL)
    private BranchHead branchHead;
    
    @OneToMany(cascade = CascadeType.ALL)
	private List<Membership> memberships;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Trainers> trainers;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<Customers> customers;
    
    public BranchHead getBranchHead() {
		return branchHead;
	}
	public void setBranchHead(BranchHead branchHead) {
		this.branchHead = branchHead;
	}
	public List<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	
	
	public List<Membership> getMemberships() {
		return memberships;
	}
	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}
	public List<Trainers> getTrainers() {
		return trainers;
	}
	public void setTrainers(List<Trainers> trainers) {
		this.trainers = trainers;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public long getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	public String getBranchTimings() {
		return branchTimings;
	}
	public void setBranchTimings(String branchTimings) {
		this.branchTimings = branchTimings;
	}
}
