package com.trafficmonkey.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.LoginModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.repository.RegistrationRepository;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
  @Inject
private  RegistrationRepository registrationRepository;
  @Inject
  private PasswordEncoder passwordEncoder;

 public RegistrationDTO saveUser(RegistrationDTO registration) {
		
		RegistrationModel registrationModel=new RegistrationModel();
		String sponsorId = registration.getName().substring(0, 3);
		Date currentDate = new Date();
		sponsorId = sponsorId + currentDate.getDate() + currentDate.getHours() + currentDate.getMinutes();
		registration.setSponsorId(sponsorId);
		BeanUtils.copyProperties(registration, registrationModel);
		
		LoginModel loginModel = new LoginModel();
		loginModel.setEmail(registration.getLogin().getEmail());
		loginModel.setPassword(passwordEncoder.encode(registration.getLogin().getPassword()));
		registrationModel.setLoginModel(loginModel);
		registrationModel=	registrationRepository.save(registrationModel);
		BeanUtils.copyProperties(registrationModel, registration);
		return registration;
	
		
	}

 public RegistrationModel findOneByEmail(String email) {
	   // log.debug("Going to get user account profile based on account id and email.");

	     RegistrationModel userAccountProfile = registrationRepository.findOneByEmail(email);

	    return userAccountProfile;
	  }
}
