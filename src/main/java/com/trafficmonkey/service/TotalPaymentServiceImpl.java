package com.trafficmonkey.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.PaymentDto;
import com.trafficmonkey.model.AccountModel;
import com.trafficmonkey.model.PaymentModel;
import com.trafficmonkey.repository.AccountRepository;
import com.trafficmonkey.repository.PaymentDetailRepository;
@Service
public class TotalPaymentServiceImpl implements TotalPaymentService {
     @Inject
     PaymentDetailRepository paymentDetailsRepository;
     @Inject
     AccountRepository accountRepository;
	@Override
	public List<PaymentDto> getAllUserDetailsForPayment(Boolean status) {
		List<PaymentModel> paymentModelList=paymentDetailsRepository.findByStatus(status);
		List<PaymentDto>paymentDtoList=new ArrayList<>();
		for(int i=0;i<paymentModelList.size();i++){
			PaymentDto paymentDto=new PaymentDto();
			Long id=paymentModelList.get(i).getUser_id();
			AccountModel accountModel=accountRepository.findByUserId(id);
			BeanUtils.copyProperties(paymentModelList.get(i),paymentDto);
			paymentDto.setAccountNumber(accountModel.getAccountNumber());
			paymentDto.setBankName(accountModel.getBankName());
			paymentDto.setIfscCode(accountModel.getIfscCode());
			paymentDtoList.add(paymentDto);
			
			}
		return paymentDtoList;
	}

}
