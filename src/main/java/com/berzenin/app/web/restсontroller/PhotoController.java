package com.berzenin.app.web.restсontroller;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.berzenin.app.model.Photo;
import com.berzenin.app.service.controller.PhotoService;
import com.berzenin.app.service.utils.LocalFilesController;

@RestController
@RequestMapping(value="/api/photo")
public class PhotoController extends GenericControllerImpl<Photo, PhotoService> {
	
	public PhotoController(PhotoService service) {
		super(service);
	}	
	
//	@PostMapping(
//			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
//			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
//			)
//	@ResponseStatus(HttpStatus.CREATED)
//	@RequestMapping(value="/uploadMultipleFiles")
//	public String adduploadMultipleFiles (@RequestParam("files") MultipartFile[] files) {
//
//	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE
			)
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/uploadFile")
	public String students(@RequestParam("file") MultipartFile file){
    	return service.add(file).toString();
	}
}
