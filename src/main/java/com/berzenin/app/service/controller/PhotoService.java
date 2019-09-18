package com.berzenin.app.service.controller;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.PhotoRepository;
import com.berzenin.app.model.Photo;

@Service
public class PhotoService extends GenericServiceImpl<Photo, PhotoRepository> {

	public PhotoService(PhotoRepository repository) {
		super(repository);
	}


}
