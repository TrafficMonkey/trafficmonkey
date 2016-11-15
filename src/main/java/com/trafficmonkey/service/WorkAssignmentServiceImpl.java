package com.trafficmonkey.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.trafficmonkey.DTO.LinkDto;
import com.trafficmonkey.DTO.WorkAssignmentDTO;
import com.trafficmonkey.model.LinkModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.model.WorkAssignmentModel;
import com.trafficmonkey.repository.LinkRepository;
import com.trafficmonkey.repository.RegistrationRepository;
import com.trafficmonkey.repository.WorkAssignmentRepository;
import com.trafficmonkey.utils.AppUtils;

@Service
@Transactional
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
		List<LinkDto> linkDtoList = new ArrayList<>();
		RegistrationModel registrationModel=registrationRepository.findOne(userId);
		String date=AppUtils.createDate();
		List<WorkAssignmentModel> workAssigmentModel=workAssignmentRepository.findByUserIdAndDate(userId,date);
		
		
		/*   Select Data from Link table               */
		if("STP-10".equals(registrationModel.getPlanType())){
			
			linkModelList= 	(List<LinkModel>) linkRepository.getByLimit(10);
			
		/*workAssignmentRepository.save(Iterable<LinkModel>linkModelList);*/
		}
		
		/* Insert data into work assigment table*/
		
		for(int i=0;i<linkModelList.size();i++){
			LinkDto linkDto=new LinkDto();
			if(workAssigmentModel.size()==0){
			WorkAssignmentModel workAssignmentModelval =new WorkAssignmentModel();
			workAssignmentModelval.setUserId(userId);
			workAssignmentModelval.setLinkId(linkModelList.get(i).getId());
			workAssignmentModelval.setDate(date);
			workAssignmentModelval.setStatus(false);
			workAssignmentRepository.save(workAssignmentModelval);
			
			
			
		}
			
			BeanUtils.copyProperties(linkModelList.get(i), linkDto);
			WorkAssignmentModel workAssignmentModel=workAssignmentRepository.findBylinkIdAndUserIdAndDate(linkModelList.get(i).getId(),userId,date);;
			linkDto.setStatus(workAssignmentModel.getStatus());
			linkDtoList.add(linkDto);
			
		}
		
		
		return linkDtoList;
		
		
	}
	
	public int updateStatus(WorkAssignmentDTO workAssigment)
	{
		WorkAssignmentDTO workAssigmentDto=new WorkAssignmentDTO();
		//WorkAssignmentModel workAssigmentModel= new WorkAssignmentModel();
		//BeanUtils.copyProperties(workAssigmentDto, target);
		String date=AppUtils.createDate();
		
		int value=workAssignmentRepository.updateStatus(workAssigment.getStatus(), date, workAssigment.getUserId(),workAssigment.getLinkId());
		//BeanUtils.copyProperties(workAssigmentModel, workAssigmentDto);
		return value;
		
	}
	
}
