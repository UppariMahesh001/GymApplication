package com.qsp.SpringBoot_GYM_Application.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_GYM_Application.dto.Customers;

public interface CustomerRep extends JpaRepository<Customers, Integer> {

}
