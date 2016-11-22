package com.trafficmonkey.utils;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.repository.ParentChildRepository;

@Component
public class ParentIdCalculate {
	@Inject
	ParentChildRepository parentChildRepository;
	
	public Long returnParentId(ParentChildDTO parentChildDto){
		Long parentId;
		ParentChildDTO parentchildDto1 = null ;
 ParentChildModel parentModel=parentChildRepository.findByparentIdAndPosition(parentChildDto.getParentId(), parentChildDto.getPosition());
	if(parentModel!=null && parentModel.getId()!=null )
	{
		
		
		parentchildDto1 = new ParentChildDTO();
		BeanUtils.copyProperties(parentModel, parentchildDto1);
		parentchildDto1.setParentId(parentModel.getRegistration().getId());
	    return returnParentId(parentchildDto1);
	
	}
	
	 
		
	else {
		parentId=parentChildDto.getParentId();
		return parentId;
	}
	
	}
	
	}


