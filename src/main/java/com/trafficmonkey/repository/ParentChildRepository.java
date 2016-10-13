package com.trafficmonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafficmonkey.model.ParentChildModel;

public interface ParentChildRepository extends JpaRepository<ParentChildModel, Long>{

}
