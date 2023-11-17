package com.qsp.SpringBoot_GYM_Application.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Gym {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gymId;
	private String gymName;
	private String gymGst;
	private String gymOwner;
	private long gymPhone;
	private String gymWebsite;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branch; 
	
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymGst() {
		return gymGst;
	}
	public void setGymGst(String gymGst) {
		this.gymGst = gymGst;
	}
	public String getGymOwner() {
		return gymOwner;
	}
	public void setGymOwner(String gymOwner) {
		this.gymOwner = gymOwner;
	}
	public long getGymPhone() {
		return gymPhone;
	}
	public void setGymPhone(long gymPhone) {
		this.gymPhone = gymPhone;
	}
	public String getGymWebsite() {
		return gymWebsite;
	}
	public void setGymWebsite(String gymWebsite) {
		this.gymWebsite = gymWebsite;
	}

}
