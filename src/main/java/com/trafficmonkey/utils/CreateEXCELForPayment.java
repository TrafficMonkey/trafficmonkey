package com.trafficmonkey.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.trafficmonkey.DTO.PaymentDto;
import com.trafficmonkey.model.PaymentModel;
import com.trafficmonkey.repository.PaymentDetailRepository;
@Component
public class CreateEXCELForPayment{
	
	@Inject
	PaymentDetailRepository paymentRepository;
	public void buildPaymentDetailTbl(List<PaymentDto> list)  {
		
	for(int i=0;i<list.size();i++){
		PaymentModel paymentModel=new PaymentModel();
		BeanUtils.copyProperties(list.get(i),paymentModel);
		paymentRepository.save(paymentModel);
	}	
	}
}

