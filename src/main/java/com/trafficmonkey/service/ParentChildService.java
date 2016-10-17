package com.trafficmonkey.service;

import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;

public interface ParentChildService {
	void saveParentChild(ParentChildDTO parentChild);
	ParentChildModel findOneByEmail(String email);

}
