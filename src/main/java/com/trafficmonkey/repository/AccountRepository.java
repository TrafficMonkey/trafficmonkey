package com.trafficmonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafficmonkey.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
AccountModel findByUserId(Long userId);
}
