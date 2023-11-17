package com.qsp.SpringBoot_GYM_Application.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_GYM_Application.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
