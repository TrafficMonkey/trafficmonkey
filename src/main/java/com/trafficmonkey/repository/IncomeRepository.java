package com.trafficmonkey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trafficmonkey.model.IncomeModel;

public interface IncomeRepository  extends JpaRepository<IncomeModel, Long> {
	List<IncomeModel>findByReferralIdAndStatusAndIncomeType(Long refferalId,Boolean status,String incomeType);
	@Query( value ="select i from IncomeModel i where i.status= :status and i.incomeType= :incomeType and i.referralId=:referralId group by i.referralId " ,nativeQuery=true)
	List<IncomeModel>findByStatusAndIncomeTypeAndReferralId(@Param("status")Boolean status,@Param("incomeType") String incomeType,@Param("referralId")Long referralId);
	
	@Query(value="select i  from IncomeModel i where i.status= :status and i.incomeType= :incomeType And  i.referralId =:referralId And i.node=:node group by i.referralId ,i.node",nativeQuery=true)
	List<IncomeModel>findByStatusAndIncomeTypeAndNode(@Param("status")Boolean status,@Param("incomeType") String incomeType,@Param("referralId")Long referralId,@Param("node")String node);
}
