package com.trafficmonkey.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.LoginModel;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.repository.ParentChildRepository;
import com.trafficmonkey.repository.RegistrationRepository;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	@Inject

	private  ParentChildRepository parentChildRepository;
  @Inject
private  RegistrationRepository registrationRepository;
  @Inject
  private PasswordEncoder passwordEncoder;

 public ParentChildModel saveUser(ParentChildDTO parentChildDto) {
		
	    ParentChildModel parentChildModel=new ParentChildModel();
		RegistrationModel registrationModel=new RegistrationModel();
		String sponsorId = parentChildDto.getRegistration().getName().substring(0,3);
		Date currentDate = new Date();
		sponsorId = sponsorId + currentDate.getDate() + currentDate.getHours() + currentDate.getMinutes();
		
		
		//registration.setSponsorId(sponsorId);
		BeanUtils.copyProperties(parentChildDto, parentChildModel);
		
		LoginModel loginModel = new LoginModel();
		//ParentChildModel parentChildModel=new ParentChildModel();
		//RegistrationModel registrationMode=new RegistrationModel();
		loginModel.setEmail(parentChildDto.getRegistration().getLogin().getEmail());
		loginModel.setPassword(passwordEncoder.encode(parentChildDto.getRegistration().getLogin().getPassword()));
		registrationModel.setLoginModel(loginModel);
		/*parentChildModel.setChildId(registration.getParentChild().getChildId());
		parentChildModel.setParentId(registration.getParentChild().getParentId())*/;
		registrationModel.setName(parentChildDto.getRegistration().getName());
		registrationModel.setNominee(parentChildDto.getRegistration().getNominee());
		registrationModel.setPanCard(parentChildDto.getRegistration().getPanCard());
		registrationModel.setPanCardFlag(parentChildDto.getRegistration().getPanCardFlag());
		registrationModel.setPlanType(parentChildDto.getRegistration().getPlanType());
		registrationModel.setSponsorId(sponsorId);
		registrationModel.setTermsAndCondition(parentChildDto.getRegistration().getTermsAndCondition());
		parentChildModel.setRegistration(registrationModel);
		parentChildModel=parentChildRepository.save(parentChildModel);
		//BeanUtils.copyProperties(registrationModel, registration);
		
		return parentChildModel;
	
		
	}

 public RegistrationModel findOneByEmail(String email) {
	   // log.debug("Going to get user account profile based on account id and email.");

	     RegistrationModel userAccountProfile = registrationRepository.findOneByEmail(email);

	    return userAccountProfile;
	  }
 public RegistrationModel getSponsorName(String sponsorId){
	 RegistrationModel registrationModel=registrationRepository.findBySponsorId(sponsorId);
	 return  registrationModel;
 }
}
