package com.trafficmonkey.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ShedularForGenratePayment {
	@Scheduled(fixedRate=1000)
 public void ShedularForCreateExclForPayment(){
		
		System.out.println("hallo");
	}
}
