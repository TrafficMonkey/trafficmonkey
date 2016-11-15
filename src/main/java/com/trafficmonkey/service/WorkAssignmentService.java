package com.trafficmonkey.service;

import java.util.List;

import com.trafficmonkey.DTO.LinkDto;
import com.trafficmonkey.DTO.WorkAssignmentDTO;

public interface WorkAssignmentService {
List<LinkDto> getTodayTaskService(Long userId);
int updateStatus(WorkAssignmentDTO workAssigment);
}
