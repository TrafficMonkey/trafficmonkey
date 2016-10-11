package com.trafficmonkey.service;

import com.trafficmonkey.DTO.RegistrationDTO;
import com.trafficmonkey.model.RegistrationModel;

public interface RegistrationService {
	void saveUser(RegistrationDTO registration);
	 RegistrationModel findOneByEmail(String email);
}
