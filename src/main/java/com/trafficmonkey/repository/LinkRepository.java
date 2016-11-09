package com.trafficmonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafficmonkey.model.LinkModel;

public interface LinkRepository extends JpaRepository<LinkModel, Long>{
	

}
