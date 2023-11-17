package com.qsp.SpringBoot_GYM_Application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressArea;
	private long addresspincode;
	private String addressCity;
	private String addressLandmark;
	private String addressState;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressArea() {
		return addressArea;
	}
	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}
	public long getAddresspincode() {
		return addresspincode;
	}
	public void setAddresspincode(long addresspincode) {
		this.addresspincode = addresspincode;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressLandmark() {
		return addressLandmark;
	}
	public void setAddressLandmark(String addressLandmark) {
		this.addressLandmark = addressLandmark;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	

}
