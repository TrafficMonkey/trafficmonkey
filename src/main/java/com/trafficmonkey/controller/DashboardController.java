package com.trafficmonkey.controller;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trafficmonkey.DTO.GenerateBinaryTreeDTO;
import com.trafficmonkey.exception.BadRequestException;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.model.RegistrationModel;
import com.trafficmonkey.service.DashboardService;
import com.traficmonkey.enums.Codes;
import com.traficmonkey.enums.ResponseKeyName;

@RestController

public class DashboardController extends BaseRestController {
@Inject
DashboardService dashboardService;
	@RequestMapping(value = "/generateTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSponsorName(
		      @RequestParam(value = "parentId", required = true) Long parentId) throws BadRequestException {
	
		List<GenerateBinaryTreeDTO> binaryTreeNode=	dashboardService.generateBinaryTree(parentId);
		
		return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.BINARYTREE, binaryTreeNode));
		
		
	}

}
