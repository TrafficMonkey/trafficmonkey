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
	  
	  //@Query("SELECT a FROM ParentChildModel a INNER JOIN a.registration b ON a.parentId = b.id WHERE (b.id = :parentId) OR b.parent_id= :parentId")
	  
	  
	  @Query(value = "SELECT  a.* FROM parent_child a inner join parent_child b  on   a.parent_id= b.registration_id   where (b.registration_id=?1)  or b.parent_id =?1", nativeQuery = true)
	  List<ParentChildModel> findByParentId(@Param("parentId") Long parentId);
	  
	  
	  
}
