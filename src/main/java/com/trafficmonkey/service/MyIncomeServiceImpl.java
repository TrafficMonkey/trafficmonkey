package com.trafficmonkey.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.IncomeDetailsDTO;
import com.trafficmonkey.model.IncomeModel;
import com.trafficmonkey.repository.IncomeRepository;
import com.traficmonkey.enums.AppConstant;
@Service
public class MyIncomeServiceImpl implements MyIncomeService {
	@Inject
	IncomeRepository incomeRepository;
	public IncomeDetailsDTO getIncome(Long refferalId,Boolean status,String incomeType){
		 IncomeDetailsDTO incomeDetailsDto=new IncomeDetailsDTO();
		 Long leftCount=0L;
	     Long rightNodeCount=0L;
	   
	     Long compleateBinary=0l;
	     List<IncomeModel> list=incomeRepository.findByReferralIdAndStatusAndIncomeType(refferalId, status, incomeType);
	   	     if(AppConstant.INCOME_TYPE_BINARY.getStringValue().equals(incomeType)){
	    	 for(int i=0; i<list.size();i++) {
	    		 if(AppConstant.NODE_TYPE_LEFT.getStringValue().equals(list.get(i).getNode())){
	    			 leftCount=leftCount+1;
	    		 }
	    		 if(AppConstant.NODE_TYPE_RIGHT.getStringValue().equals(list.get(i).getNode())){
	    			 rightNodeCount=rightNodeCount+1;
	    		 } 
	    	 }
	    	 if(leftCount<=rightNodeCount){
	    		 compleateBinary=leftCount;
	    	 }
	    	 else{
	    		 compleateBinary=rightNodeCount;
	    	 }
	    	 incomeDetailsDto.setLeftNodeCount(leftCount);
	    	 incomeDetailsDto.setRightNodeCount(rightNodeCount);
	    	 incomeDetailsDto.setAmmount(compleateBinary*AppConstant.INCOME_TYPE_BINARY_AMMOUNT.getValue());
	    	 incomeDetailsDto.setChildNode(compleateBinary);
	    	 
	     }
	       else{
	    	 incomeDetailsDto.setChildNode((long)list.size());
    		 incomeDetailsDto.setAmmount((long)(list.size())*(AppConstant.INCOME_TYPE_DI_AMMOUNT.getValue()));
	     }
		return incomeDetailsDto;
	}

}
