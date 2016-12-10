package com.trafficmonkey.service;

import java.util.List;

import com.trafficmonkey.DTO.IncomeDetailsDTO;
import com.trafficmonkey.DTO.PaymentDto;
import com.trafficmonkey.model.IncomeModel;

public interface MyIncomeService {
	IncomeDetailsDTO getIncome(Long refferalId,Boolean status,String incomeType);
	List<PaymentDto> getPaymentDetails();

}
