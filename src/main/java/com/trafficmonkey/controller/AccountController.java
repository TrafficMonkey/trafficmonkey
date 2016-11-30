package com.trafficmonkey.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trafficmonkey.DTO.AccountDTO;
import com.trafficmonkey.service.AccountService;

@RestController
public class AccountController extends BaseRestController {
	@Inject
	AccountService accountService;
	@RequestMapping(value = "/accountDetails/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveAccountDetailsOfUser(@RequestBody  AccountDTO accountDto){
		System.out.println(accountDto.getAccountHolderName());
		accountService.saveAccountDetailsOfUser(accountDto);
		return null;
	}
}
