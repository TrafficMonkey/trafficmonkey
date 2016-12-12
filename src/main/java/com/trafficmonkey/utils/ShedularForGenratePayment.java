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
	@Inject
	CreateEXCELForPayment createXls;
	@Scheduled(cron="0 25 00 * * MON")
 public void ShedularForCreateExclForPayment() throws Exception{
		System.out.println("hi===++>>>>>>>>>>>>>>>>>>>>.");
		List<PaymentDto> paymentDtoList=myIncomeService.getPaymentDetails();
		for(int i=0;i<paymentDtoList.size();i++){
			System.out.println(paymentDtoList.get(i).getDirectReferralIncome());
			System.out.println(paymentDtoList.get(i).getBinaryIncome());
		}
		createXls.buildExcelDocument(paymentDtoList);
	}
}
