package com.trafficmonkey.service;

import com.trafficmonkey.DTO.IncomeDetailsDTO;

public interface MyIncomeService {
	IncomeDetailsDTO getIncome(Long refferalId,Boolean status,String incomeType);

}
