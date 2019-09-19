package com.berzenin.app.service.controller;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.ObjectPlaceRepository;
import com.berzenin.app.model.ObjectPlace;

@Service
public class ObjectPlaceService extends GenericServiceImpl<ObjectPlace, ObjectPlaceRepository> {

	public ObjectPlaceService(ObjectPlaceRepository repository) {
		super(repository);
	}

}
