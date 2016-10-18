package com.trafficmonkey.service;

import java.util.List;

import org.json.JSONArray;

import com.trafficmonkey.DTO.GenerateBinaryTreeDTO;
import com.trafficmonkey.model.ParentChildModel;

public interface DashboardService {
	List<GenerateBinaryTreeDTO>  generateBinaryTree(Long parentId);
}
