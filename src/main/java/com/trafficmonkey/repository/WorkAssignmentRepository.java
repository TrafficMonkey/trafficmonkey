package com.trafficmonkey.repository;

import java.util.List;

import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafficmonkey.model.WorkAssignmentModel;

public interface WorkAssignmentRepository extends JpaRepository<WorkAssignmentModel, Long> {
	//@Query("SELECT r FROM WorkAssignmentModel r WHERE r.userId=:userId")
List<WorkAssignmentModel> findByUserId(Long userId);
	
}
