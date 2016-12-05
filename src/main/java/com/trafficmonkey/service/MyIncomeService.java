package com.trafficmonkey.service;

import com.trafficmonkey.DTO.IncomeDetailsDTO;
import com.trafficmonkey.model.IncomeModel;

public interface MyIncomeService {
	IncomeDetailsDTO getIncome(Long refferalId,Boolean status,String incomeType);
	IncomeModel getDirectReferralDetails();

}
