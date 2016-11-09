package com.trafficmonkey.service;

import java.util.List;

import com.trafficmonkey.DTO.LinkDto;

public interface WorkAssignmentService {
List<LinkDto> getTodayTaskService(Long userId);
}
