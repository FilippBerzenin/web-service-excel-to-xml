package com.berzenin.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berzenin.app.model.Client;
import com.berzenin.app.service.controller.ClientService;

@Controller
@RequestMapping(value="/client")
public class PhotoViewController extends GenericViewControllerImpl<Client, ClientService> {

	
	public 	PhotoViewController(ClientService service) {
		page = "client";
	}
	


}
