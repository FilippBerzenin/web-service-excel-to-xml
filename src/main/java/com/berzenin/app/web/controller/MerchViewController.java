package com.berzenin.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berzenin.app.model.Merch;
import com.berzenin.app.service.controller.MerchService;

@Controller
@RequestMapping(value="/merch")
public class MerchViewController extends GenericViewControllerImpl<Merch, MerchService> {
	
	public MerchViewController(MerchService service) {
		page = "merch";
	}
	
	@ModelAttribute("new_merch")
	public Merch getLoginForm() {
		return new Merch();
	}
	}
