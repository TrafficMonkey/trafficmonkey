package com.trafficmonkey.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.trafficmonkey.DTO.PaymentDto;
@Component
public class CreateEXCELForPayment{
	
	
	protected void buildExcelDocument(List<PaymentDto> list) throws Exception { //Create blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      //Create a blank sheet
	      XSSFSheet spreadsheet = workbook.createSheet( 
	      " Employee Info ");
	      //Create row object
	      XSSFRow row;
	      //This data needs to be written (Object[])
	      Map < String, Object[] > empinfo = 
	      new TreeMap < String, Object[] >();
	      empinfo.put( "1", new Object[] { 
	      "EMP ID", "EMP NAME", "DESIGNATION" });
	     /* empinfo.put( "2", new Object[] { 
	      "tp01", "Gopal", "Technical Manager" });
	      empinfo.put( "3", new Object[] { 
	      "tp02", "Manisha", "Proof Reader" });
	      empinfo.put( "4", new Object[] { 
	      "tp03", "Masthan", "Technical Writer" });
	      empinfo.put( "5", new Object[] { 
	      "tp04", "Satish", "Technical Writer" });
	      empinfo.put( "6", new Object[] { 
	      "tp05", "Krishna", "Technical Writer" });
	     */ //Iterate over data and write to sheet
	      //Set < String > keyid = empinfo.keySet();
	      int rowid = 0;
	      for (int i=0;i<list.size();i++)
	      {
	         row = spreadsheet.createRow(rowid++);
	         Object [] objectArr = empinfo.get(i);
	         int cellid = 0;
	         for (Object obj : objectArr)
	         {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      File f = new File("d:/Example2.xlsx");

	      //Write the workbook in file system
	      FileOutputStream out = new FileOutputStream(f,false);
	      workbook.write(out);
	      out.close();
	      System.out.println( 
	      "Writesheet.xlsx written successfully" );}
}

