package com.qsp.SpringBoot_GYM_Application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int membershipId;
	private String membershipName;
	private double membershipPrice;
	private String membershipDuration;
	private double membershipDiscount;
	
	public int getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}
	public String getMembershipName() {
		return membershipName;
	}
	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}
	public double getMembershipPrice() {
		return membershipPrice;
	}
	public void setMembershipPrice(double membershipPrice) {
		this.membershipPrice = membershipPrice;
	}
	public String getMembershipDuration() {
		return membershipDuration;
	}
	public void setMembershipDuration(String membershipDuration) {
		this.membershipDuration = membershipDuration;
	}
	public double getMembershipDiscount() {
		return membershipDiscount;
	}
	public void setMembershipDiscount(double membershipDiscount) {
		this.membershipDiscount = membershipDiscount;
	}
	
	

}
