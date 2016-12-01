package com.trafficmonkey.service;

import com.trafficmonkey.DTO.AccountDTO;
import com.trafficmonkey.model.AccountModel;

public interface AccountService {
	AccountDTO saveAccountDetailsOfUser(AccountDTO accountDTO);
	AccountDTO getUserAccountDetails(Long user_Id);
}
