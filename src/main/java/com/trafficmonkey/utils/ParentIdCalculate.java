package com.trafficmonkey.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

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
	ArrayList<ParentChildModel> parentModel=parentChildRepository.findByparentIdAndPosition(parentChildDto.getParentId(), parentChildDto.getPosition());
	if(parentModel.size()>=1 )
	{
		Collections.sort(parentModel, new Comparator<ParentChildModel>() {
		    @Override
		    public int compare(ParentChildModel o1, ParentChildModel o2) {
		        return o1.getId().compareTo(
		                o2.getId());
		    }

			
		});
		
	 parentId=parentModel.get(parentModel.size()-1).getRegistration().getId();
	return parentId;
	}
	else {
		parentId=parentChildDto.getParentId();
		return parentId;
	}
	
	}
	
	}


