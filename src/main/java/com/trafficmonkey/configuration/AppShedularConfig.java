package com.trafficmonkey.configuration;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.trafficmonkey.service.MyIncomeService;
import com.trafficmonkey.utils.ShedularForGenratePayment;

@Configuration
@EnableScheduling
public class AppShedularConfig {

@Bean
public ShedularForGenratePayment myTask(){
	return new ShedularForGenratePayment();
}

}
