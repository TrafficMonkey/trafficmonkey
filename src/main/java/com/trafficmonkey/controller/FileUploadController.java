package com.trafficmonkey.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.exception.BadRequestException;
import com.trafficmonkey.exception.TrafficMonkeyException;
import com.trafficmonkey.model.RegistrationModel;
import com.traficmonkey.enums.Codes;

@RestController
public class FileUploadController extends BaseRestController {
	@RequestMapping(value = "/upload/", method = RequestMethod.PUT)
	public ResponseEntity uploadProfileImg(HttpServletRequest request) throws IOException{
		System.out.println("hallo arti ======>>>>>>>>>>");
		 if (request instanceof MultipartHttpServletRequest) {
		       System.out.println("in I f block ===>>>>");
		    }
		 else {
			 System.out.println("elase block====!!!!!");
		 }
		//String str=multipartRequest.get 
		/*Iterator<String> itr = multipartRequest.getFileNames();
		System.out.print("multipartRequest.getFileNames()====");
		System.out.println(multipartRequest.getFileNames());

        while (itr.hasNext()) {
            String uploadedFile = itr.next();
            MultipartFile file = multipartRequest.getFile(uploadedFile);
            String mimeType = file.getContentType();
            String filename = file.getOriginalFilename();
            byte[] bytes = file.getBytes();

           System.out.println(bytes);
           // FileUpload newFile = new FileUpload(filename, bytes, mimeType);

            ///fileUploadService.uploadFile(newFile);
        }*/
		
		return null;
	}
			
 
}
