package com.trafficmonkey.service;

import java.sql.Blob;

import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.IncomeModel;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;

public interface RegistrationService {
	ParentChildModel saveUser(ParentChildDTO parentChildDto);
	RegistrationModel findOneByEmail(String email);
	RegistrationDTO getSponsorName(String sponsorId);
	void saveProfileImage(Blob profileImg , Long Id);
	Long findReferralUserId(String referralId);
	IncomeModel saveDirectReferral(Long referralId, ParentChildModel parentChildModel);
}
