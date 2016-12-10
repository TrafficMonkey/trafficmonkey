package com.trafficmonkey.utils;

import java.util.List;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.trafficmonkey.DTO.PaymentDto;
import com.trafficmonkey.service.MyIncomeService;

@Component
public class ShedularForGenratePayment {
	@Inject
	MyIncomeService myIncomeService;
	@Scheduled(cron = "0 30 2 ? * SUN")
 public void ShedularForCreateExclForPayment(){
		List<PaymentDto> paymentDtoList=myIncomeService.getPaymentDetails();
		for(int i=0;i<paymentDtoList.size();i++){
			System.out.println(paymentDtoList.get(i).getDirectReferralIncome());
			System.out.println(paymentDtoList.get(i).getBinaryIncome());
		}
		
	}
}
