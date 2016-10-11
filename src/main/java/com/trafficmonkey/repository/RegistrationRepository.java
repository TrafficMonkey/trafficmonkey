package com.trafficmonkey.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trafficmonkey.model.RegistrationModel;


public interface RegistrationRepository extends  JpaRepository<RegistrationModel, Long> {

	   @Query("SELECT r FROM RegistrationModel r WHERE r.loginModel.email=:email")
	  RegistrationModel findOneByEmail(@Param("email") String email);
}
