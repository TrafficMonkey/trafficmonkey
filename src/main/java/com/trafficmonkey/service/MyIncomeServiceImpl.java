package com.trafficmonkey.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.IncomeDTO;
import com.trafficmonkey.DTO.IncomeDetailsDTO;
import com.trafficmonkey.DTO.PaymentDto;
import com.trafficmonkey.model.IncomeModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.repository.AccountRepository;
import com.trafficmonkey.repository.IncomeRepository;
import com.trafficmonkey.repository.RegistrationRepository;
import com.traficmonkey.enums.AppConstant;
@Service
public class MyIncomeServiceImpl implements MyIncomeService {
	@Inject
	IncomeRepository incomeRepository;
	@Inject
	RegistrationRepository registrationRepository;
	@Inject
	AccountRepository accountRepository;
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
	
	@Scheduled(fixedRate=1000)
public  IncomeModel getDirectReferralDetails(){
	PaymentDto paymentDTO=new PaymentDto();
	
	int compleateBinery;
	List<RegistrationModel>list=registrationRepository.findAll();
	paymentDTO.setUser_id(list.get(0).getId());
	paymentDTO.setUserName(list.get(0).getName());
	for(int i=0; i<list.size();i++){
		List<IncomeModel> incomeModelForDirectIncome=incomeRepository.findByStatusAndIncomeTypeAndReferralId(false, AppConstant.INCOME_TYPE_DI.getStringValue(),list.get(i).getId());
		paymentDTO.setDirectReferralIncome(incomeModelForDirectIncome.size()*AppConstant.INCOME_TYPE_DI_AMMOUNT.getValue());
		
		List<IncomeModel> incomeModelBinaryIncomeLeftNode=incomeRepository.findByStatusAndIncomeTypeAndNode(false, AppConstant.INCOME_TYPE_BINARY.getStringValue(),list.get(i).getId(),AppConstant.NODE_TYPE_LEFT.getStringValue());
		List<IncomeModel> incomeModelBinaryIncomeRightNode=incomeRepository.findByStatusAndIncomeTypeAndNode(false, AppConstant.INCOME_TYPE_BINARY.getStringValue(),list.get(i).getId(),AppConstant.NODE_TYPE_RIGHT.getStringValue());
		if(incomeModelBinaryIncomeLeftNode.size()<incomeModelBinaryIncomeRightNode.size()){
			compleateBinery=incomeModelBinaryIncomeLeftNode.size();
		}
		else{
			compleateBinery=incomeModelBinaryIncomeRightNode.size();
		
		}
		paymentDTO.setCompleteBinary(compleateBinery);
		paymentDTO.setBinaryIncome(compleateBinery*AppConstant.INCOME_TYPE_BINARY_AMMOUNT.getValue());
		
	}
	
	
	
	return null;
}
}
