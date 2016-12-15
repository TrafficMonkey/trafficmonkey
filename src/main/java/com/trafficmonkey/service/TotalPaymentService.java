package com.trafficmonkey.service;

import java.util.List;

import com.trafficmonkey.DTO.PaymentDto;

public interface TotalPaymentService {
List<PaymentDto> getAllUserDetailsForPayment(Boolean status);
}
