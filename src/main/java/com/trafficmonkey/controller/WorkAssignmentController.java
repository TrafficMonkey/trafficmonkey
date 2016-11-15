package com.trafficmonkey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trafficmonkey.DTO.GenerateBinaryTreeDTO;
import com.trafficmonkey.DTO.LinkDto;
import com.trafficmonkey.DTO.WorkAssignmentDTO;
import com.trafficmonkey.exception.BadRequestException;
import com.trafficmonkey.service.WorkAssignmentService;
import com.traficmonkey.enums.ResponseKeyName;

@RestController
public class WorkAssignmentController extends BaseRestController{
	
	@Autowired
	WorkAssignmentService workAssignmentService;
	
	@RequestMapping(value = "/todayTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getTodayTask( @RequestParam(value = "userId", required = true) Long userId) throws BadRequestException {
	
		
		List<LinkDto> linkDtolist =workAssignmentService.getTodayTaskService(userId);
		return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.TODAY_TASK, linkDtolist));
	}
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateStause(@RequestBody WorkAssignmentDTO workAssignment) throws BadRequestException {
		workAssignmentService.updateStatus(workAssignment);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
