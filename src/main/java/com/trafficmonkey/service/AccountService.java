package com.trafficmonkey.service;

import com.trafficmonkey.DTO.AccountDTO;
import com.trafficmonkey.model.AccountModel;

public interface AccountService {
	AccountModel saveAccountDetailsOfUser(AccountDTO accountDTO);
}
