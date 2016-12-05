package com.trafficmonkey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trafficmonkey.model.IncomeModel;

public interface IncomeRepository  extends JpaRepository<IncomeModel, Long> {
	List<IncomeModel>findByReferralIdAndStatusAndIncomeType(Long refferalId,Boolean status,String incomeType);
	@Query("select i from IncomeModel i where i.status= :status and i.incomeType= :incomeType group by i.referralId ")
	List<IncomeModel>findByStatusAndIncomeType(@Param("status")Boolean status,@Param("incomeType") String incomeType);
	
	@Query("select i from IncomeModel i where i.status= :status and i.incomeType= :incomeType group by i.referralId ,i.node")
	List<IncomeModel>findByStatusAndIncomeTypeAndNode(@Param("status")Boolean status,@Param("incomeType") String incomeType);
}
