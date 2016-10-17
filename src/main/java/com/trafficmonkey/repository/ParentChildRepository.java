package com.trafficmonkey.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trafficmonkey.model.ParentChildModel;

public interface ParentChildRepository extends JpaRepository<ParentChildModel, Long>{
	ArrayList<ParentChildModel>findByparentIdAndPosition(@Param("parentId") Long parentId,@Param("position") String position);
	  @Query("SELECT r FROM ParentChildModel r WHERE r.registration.loginModel.email=:email")
	ParentChildModel findOneByEmail(@Param("email") String email);
	  @Query("SELECT p FROM ParentChildModel p WHERE p.registration.id=:id")
	  ParentChildModel findByRegistration(@Param("id") Long id);
	  List<ParentChildModel> findByParentId(@Param("parentId") Long parentId);
	  
	  
	  
}
