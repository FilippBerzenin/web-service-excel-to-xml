package com.berzenin.app.web.restсontroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.berzenin.app.model.ExcelList;
import com.berzenin.app.service.controller.ExcelFileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FilesRequestController {
	
	@Autowired
	private ExcelFileService excelFileService;
	

    @CrossOrigin(origins = "http://localhost:8080")
	@PostMapping (produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/submit")
	public String submitFileFromAjaxRequest (
			@RequestParam("data") MultipartFile file
			) {
		log.info("submit method");
		log.info(file.getOriginalFilename());
				return "ok";
		
	}
    
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/fileUpload")
    public List<ExcelList> fileUpload(
    		@RequestParam("file") MultipartFile file)throws IOException {
    	log.info("Get excel file: "+file.getOriginalFilename());
//    	List<String> ss = new ArrayList<>();
//    	ss.add("Hello");
//    	ss.add("Filipp");
//    	ss.add("Vika");
//    	return ss;
       if (!file.getOriginalFilename().isEmpty()) {
    	   File fileTemp = File.createTempFile(file.getOriginalFilename()+"temp", "xlsx");
    	   file.transferTo(fileTemp);
    	   List<ExcelList> excelLists = excelFileService.getAllSheetName(fileTemp).get();
//    	   return new ResponseEntity<ss>("File Uploaded Successfully.",HttpStatus.OK);
    	   return excelLists;
       }else{
//          return new ResponseEntity<ss>("Invalid file.",HttpStatus.BAD_REQUEST);
       }
	return null;       
    }
}
