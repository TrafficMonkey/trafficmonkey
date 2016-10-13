package com.trafficmonkey.service;

import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.RegistrationModel;

public interface RegistrationService {
	RegistrationDTO saveUser(RegistrationDTO registration);
	RegistrationModel findOneByEmail(String email);
	RegistrationModel getSponsorName(String sponsorId);
}
