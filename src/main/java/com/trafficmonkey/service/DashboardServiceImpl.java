package com.trafficmonkey.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.trafficmonkey.DTO.GenerateBinaryTreeDTO;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.repository.ParentChildRepository;

@Service
public class DashboardServiceImpl implements DashboardService {
//	JSONArray jsonArray = new JSONArray();
	List<GenerateBinaryTreeDTO>generateBinaryTreeDTOList;
	@Inject
	ParentChildRepository parentChildRepository;
	public List<GenerateBinaryTreeDTO> generateBinaryTree(Long parentId){
		generateBinaryTreeDTOList=new ArrayList<>();
		ParentChildModel parentChildModel= parentChildRepository.findByRegistration(parentId);
		/*JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", parentChildModel.getRegistration().getId());
		jsonObject.put("Name", parentChildModel.getRegistration().getName());
		jsonObject.put("parent", parentChildModel.getParentId());
		jsonArray.put(0, jsonObject);*/
		GenerateBinaryTreeDTO generateBinaryTreeDTO=new GenerateBinaryTreeDTO();
		generateBinaryTreeDTO.setId(parentChildModel.getRegistration().getId());
		generateBinaryTreeDTO.setName(parentChildModel.getRegistration().getName());
		generateBinaryTreeDTO.setParent(0L);
		generateBinaryTreeDTOList.add(generateBinaryTreeDTO);
		generateBinaryTreeDTOList=	getChildNodes(parentChildModel.getRegistration().getId());
		
		return generateBinaryTreeDTOList;
	}
	
	private List<GenerateBinaryTreeDTO> getChildNodes(Long parentId){
		
		
		
	List<ParentChildModel> childNodesList	=parentChildRepository.findByParentId(parentId);
	for(int i=0;i<childNodesList.size();i++){
		GenerateBinaryTreeDTO generateBinaryTreeDTO=new GenerateBinaryTreeDTO();
		generateBinaryTreeDTO.setId(childNodesList.get(i).getRegistration().getId());
		generateBinaryTreeDTO.setName(childNodesList.get(i).getRegistration().getName());
		generateBinaryTreeDTO.setParent(childNodesList.get(i).getParentId());
		/*JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", childNodesList.get(i).getRegistration().getId());
		jsonObject.put("Name", childNodesList.get(i).getRegistration().getName());
		jsonObject.put("parent", childNodesList.get(i).getParentId());
		jsonArray.put(j, jsonObject);
		j++;*/
		
		generateBinaryTreeDTOList.add(generateBinaryTreeDTO);
		
		
	}
	//JSONObject jsonObject = new JSONObject();
	
	
		return generateBinaryTreeDTOList;
	}
}
