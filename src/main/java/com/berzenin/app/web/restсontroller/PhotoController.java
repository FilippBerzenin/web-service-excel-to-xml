package com.berzenin.app.web.restсontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berzenin.app.model.Client;
import com.berzenin.app.service.controller.ClientService;

@RestController
@RequestMapping(value="/api/client")
public class PhotoController extends GenericControllerImpl<Client, ClientService> {
	
	
	public PhotoController(ClientService service) {
		super(service);
	}

}
