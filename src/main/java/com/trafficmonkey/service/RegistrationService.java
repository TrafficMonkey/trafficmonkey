package com.trafficmonkey.service;

import java.sql.Blob;

import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.model.IncomeModel;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;

public interface RegistrationService {
	ParentChildModel saveUser(ParentChildDTO parentChildDto);
	RegistrationModel findOneByEmail(String email);
	RegistrationModel getSponsorName(String sponsorId);
	void saveProfileImage(Blob profileImg , Long Id);
	Long findReferralUserId(String referralId);
	IncomeModel saveIncome(Long referralId, ParentChildDTO parentChildDto);
}
