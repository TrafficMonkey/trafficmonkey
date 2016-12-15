package com.trafficmonkey.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trafficmonkey.DTO.PaymentDto;
import com.trafficmonkey.service.MyIncomeService;
import com.trafficmonkey.service.TotalPaymentService;
import com.traficmonkey.enums.ResponseKeyName;

@RestController
public class TotalPayment extends BaseRestController {
	@Inject
	TotalPaymentService totalPaymentService;
	@RequestMapping(value = "/getUserDetailsForTotalPayment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSponsorName() {
	
		//myIncomeService.getDirectReferralDetails();
		List<PaymentDto> paymentDtoList=totalPaymentService.getAllUserDetailsForPayment(false);
		return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.PAYMENT_DETAILS_LIST, paymentDtoList));
		
	}
		
	}


