package com.trafficmonkey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafficmonkey.model.IncomeModel;

public interface IncomeRepository  extends JpaRepository<IncomeModel, Long> {
	List<IncomeModel>findByReferralIdAndStatusAndIncomeType(Long refferalId,Boolean status,String incomeType);
}
