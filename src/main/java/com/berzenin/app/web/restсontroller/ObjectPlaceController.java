package com.berzenin.app.web.restсontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berzenin.app.model.ObjectPlace;
import com.berzenin.app.service.controller.ObjectPlaceService;

@RestController
@RequestMapping(value = "/api/shop")
public class ObjectPlaceController extends GenericControllerImpl<ObjectPlace, ObjectPlaceService> {

	public ObjectPlaceController(ObjectPlaceService service) {
		super(service);
	}
}
