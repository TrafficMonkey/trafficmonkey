package com.trafficmonkey.service;

import java.sql.Blob;
import java.util.Date;

import javax.inject.Inject;

//import com.trafficmonkey.utils.CalculateParentId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.trafficmonkey.DTO.IncomeDTO;
import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.IncomeModel;
import com.trafficmonkey.model.LoginModel;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.repository.IncomeRepository;
import com.trafficmonkey.repository.ParentChildRepository;
import com.trafficmonkey.repository.RegistrationRepository;
import com.trafficmonkey.utils.AppUtils;
import com.trafficmonkey.utils.ParentIdCalculate;
import com.traficmonkey.enums.AppConstant;



@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
  @Inject
  private  ParentChildRepository parentChildRepository;
  @Inject
  private  RegistrationRepository registrationRepository;
  @Inject
  private PasswordEncoder passwordEncoder;
  @Inject
  ParentIdCalculate parentIdCalculate;
  @Inject
  private IncomeRepository incomeRepository;
 
 public ParentChildModel saveUser(ParentChildDTO parentChildDto) {
		
	    ParentChildModel parentChildModel=new ParentChildModel();
		RegistrationModel registrationModel=new RegistrationModel();
		String sponsorId = parentChildDto.getRegistration().getName().substring(0,3);
		Date currentDate = new Date();
		sponsorId = sponsorId + currentDate.getDate() + currentDate.getHours() + currentDate.getMinutes();
		if(StringUtils.isNotEmpty(parentChildDto.getSponsorId()))
		parentChildDto.setParentId(parentIdCalculate.returnParentId(parentChildDto));
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
 
 public RegistrationDTO getSponsorName(String sponsorId){
	 RegistrationModel registrationModel=registrationRepository.findBySponsorId(sponsorId);
	 RegistrationDTO registrationDTO =new RegistrationDTO();
	 BeanUtils.copyProperties(registrationModel, registrationDTO);
	 
	 
	 return  registrationDTO;
 }
 

public void saveProfileImage(Blob profileImg , Long Id){
 registrationRepository.saveProfileImg(Id, profileImg);
	
	 
 }



public Long findReferralUserId(String referralId)
{
	 RegistrationModel registrationModel=	registrationRepository.findBySponsorId(referralId);
	 return registrationModel.getId();
}
public IncomeModel saveDirectReferral(Long referralId, ParentChildModel parentChildMode)
{
	IncomeDTO incomeDto=new IncomeDTO();
	IncomeModel incomeModel=new IncomeModel();
	incomeDto.setUserId(parentChildMode.getRegistration().getId());
	incomeDto.setReferralId(referralId);
	incomeDto.setDate(AppUtils.createDate());
	incomeDto.setIncomeType(AppConstant.INCOME_TYPE_DI.getStringValue());
	BeanUtils.copyProperties(incomeDto, incomeModel);
	incomeRepository.save(incomeModel);
	return incomeModel;
}



}
