package com.trafficmonkey.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.LinkDto;
import com.trafficmonkey.model.LinkModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.model.WorkAssignmentModel;
import com.trafficmonkey.repository.LinkRepository;
import com.trafficmonkey.repository.RegistrationRepository;
import com.trafficmonkey.repository.WorkAssignmentRepository;

@Service
public class WorkAssignmentServiceImpl implements WorkAssignmentService {
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	WorkAssignmentRepository workAssignmentRepository;
	@Autowired
	LinkRepository linkRepository;
	@SuppressWarnings("unchecked")
	public List<LinkDto> getTodayTaskService(Long userId){
		List<LinkModel>linkModelList = new ArrayList<>();
		List<LinkDto> linkDto = new ArrayList<>();
		RegistrationModel registrationModel=registrationRepository.findOne(userId);
		Date currentDate = new Date();
		String date=currentDate.getYear()+"-"+currentDate.getMonth()+"-"+currentDate.getDate();
		List<WorkAssignmentModel> workAssigmentModel=workAssignmentRepository.findByUserIdAndDate(userId,date);
		
		
		/*   Select Data from Link table               */
		if("STP-10".equals(registrationModel.getPlanType())){
			
			linkModelList= 	(List<LinkModel>) linkRepository.getByLimit(4);
			
		/*workAssignmentRepository.save(Iterable<LinkModel>linkModelList);*/
		}
		
		/* Insert data into work assigment table*/
		if(workAssigmentModel.size()==0){
		for(int i=0;i<linkModelList.size();i++){
			WorkAssignmentModel workAssignmentModelval =new WorkAssignmentModel();
			workAssignmentModelval.setUserId(userId);
			workAssignmentModelval.setLinkId(linkModelList.get(i).getId());
			workAssignmentModelval.setDate(date);
			workAssignmentRepository.save(workAssignmentModelval);
		}
		}
		return linkDto;
		
		
	}
}
