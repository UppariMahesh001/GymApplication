package com.qsp.SpringBoot_GYM_Application.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.SpringBoot_GYM_Application.dto.Membership;

public interface MembershipRepo extends JpaRepository<Membership, Integer> {

}
