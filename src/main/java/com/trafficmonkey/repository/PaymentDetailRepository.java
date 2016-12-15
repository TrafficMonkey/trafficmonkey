package com.trafficmonkey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafficmonkey.model.PaymentModel;

public interface PaymentDetailRepository extends JpaRepository<PaymentModel, Long> {
	List<PaymentModel> findByStatus(Boolean status);

}
