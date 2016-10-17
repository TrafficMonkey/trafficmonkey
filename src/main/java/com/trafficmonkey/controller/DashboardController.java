package com.trafficmonkey.controller;

import java.text.MessageFormat;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trafficmonkey.exception.BadRequestException;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.service.DashboardService;
import com.traficmonkey.enums.Codes;
import com.traficmonkey.enums.ResponseKeyName;

@RestController

public class DashboardController extends BaseRestController {
@Inject
DashboardService dashboardService;
	@RequestMapping(value = "/generateTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSponsorName(
		      @RequestParam(value = "parentId", required = true) Long parentId) throws BadRequestException {
		//RegistrationModel registration=registrationService.getSponsorName(sponsorId);
		
		dashboardService.generateBinaryTree(parentId);
		
		throw new BadRequestException(Codes.NOT_EXIST_SPONSOR_ID);
		
		
	}

}
