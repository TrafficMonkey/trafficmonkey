package com.trafficmonkey.service;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.AccountDTO;
import com.trafficmonkey.model.AccountModel;
import com.trafficmonkey.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
   @Inject
    AccountRepository accountRepository;
	@Override
	public AccountModel saveAccountDetailsOfUser(AccountDTO accountDTO) {
		
		AccountModel accountModel=new AccountModel();
		BeanUtils.copyProperties(accountDTO, accountModel);
		accountModel=accountRepository.save(accountModel);
		return accountModel;
	} 

}
