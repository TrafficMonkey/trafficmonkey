package com.trafficmonkey.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		/*Collections.sort(parentModel, new Comparator<ParentChildModel>() {
		    @Override
		    public int compare(ParentChildModel o1, ParentChildModel o2) {
		        return o1.getId().compareTo(
		                o2.getId());
		    }

			
		});
		
	 parentId=parentModel.get(parentModel.size()-1).getRegistration().getId();*/
		
		parentchildDto1 = new ParentChildDTO();
		BeanUtils.copyProperties(parentModel, parentchildDto1);
		parentchildDto1.setParentId(parentModel.getId());
	    return returnParentId(parentchildDto1);
	
	}
	
	  /* else if(parentModel.getRegistration()==null){
		
		  return parentchildDto.getParentId();
	}*/
		
	else {
		parentId=parentChildDto.getParentId();
		return parentId;
	}
	
	}
	
	}


