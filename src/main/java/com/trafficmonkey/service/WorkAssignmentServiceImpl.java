package com.trafficmonkey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.LinkDto;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.model.WorkAssignmentModel;
import com.trafficmonkey.repository.RegistrationRepository;
import com.trafficmonkey.repository.WorkAssignmentRepository;

@Service
public class WorkAssignmentServiceImpl implements WorkAssignmentService {
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	WorkAssignmentRepository workAssignmentRepository;
	public List<LinkDto> getTodayTaskService(Long userId){
		List<LinkDto> linkDto = new ArrayList<>();
		RegistrationModel registrationModel=registrationRepository.findOne(userId);
		List<WorkAssignmentModel> workAssigmentModel=workAssignmentRepository.findByUserId(userId);
		if("STP-10".equals(registrationModel.getPlanType())){
			
		}
		return linkDto;
		
		
	}
}
