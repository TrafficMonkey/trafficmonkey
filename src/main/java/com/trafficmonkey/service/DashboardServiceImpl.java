package com.trafficmonkey.service;

import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.repository.ParentChildRepository;

@Service
public class DashboardServiceImpl implements DashboardService {
	JSONArray jsonArray = new JSONArray();
	@Inject
	ParentChildRepository parentChildRepository;
	public Object generateBinaryTree(Long parentId){
		ParentChildModel parentChildModel= parentChildRepository.findByRegistration(parentId);
		getChildNodes(parentChildModel.getRegistration().getId());
		
		return null;
	}
	
	private JSONObject getChildNodes(Long parentId){
	
	List<ParentChildModel> childNodesList	=parentChildRepository.findByParentId(parentId);
	//JSONObject jsonObject = new JSONObject();
	
	
	if(childNodesList.size()!=0){
		
		for(int i=0;i<childNodesList.size();i++)
		{
			jsonArray.put(childNodesList);
			this.getChildNodes(childNodesList.get(i).getParentId());
		}
		
	}
		
		return null;
	}
}
