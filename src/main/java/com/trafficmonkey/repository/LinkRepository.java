package com.trafficmonkey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafficmonkey.model.LinkModel;

public interface LinkRepository extends JpaRepository<LinkModel, Long>{
	@Query(value="select * from   Link Limit ?1",nativeQuery = true)
	List<LinkModel> getByLimit(int limit);

}
