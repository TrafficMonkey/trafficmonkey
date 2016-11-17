package com.trafficmonkey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafficmonkey.model.IncomeModel;

public interface IncomeRepository  extends JpaRepository<IncomeModel, Long> {

}
