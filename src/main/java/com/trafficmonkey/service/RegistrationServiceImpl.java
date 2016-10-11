package com.trafficmonkey.service;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trafficmonkey.DTO.LoginDTO;
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

 public void saveUser(RegistrationDTO registration) {
		
		RegistrationModel registrationModel=new RegistrationModel();
		BeanUtils.copyProperties(registration, registrationModel);
		LoginModel loginModel = new LoginModel();
		loginModel.setEmail(registration.getLogin().getEmail());
		loginModel.setPassword(passwordEncoder.encode(registration.getLogin().getPassword()));
		registrationModel.setLoginModel(loginModel);
		registrationModel=	registrationRepository.save(registrationModel);
	
		
	}

 public RegistrationModel findOneByEmail(String email) {
	   // log.debug("Going to get user account profile based on account id and email.");

	     RegistrationModel userAccountProfile = registrationRepository.findOneByEmail(email);

	    return userAccountProfile;
	  }
}
