package com.berzenin.app.web.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.berzenin.app.model.ExcelConfiguration;
import com.berzenin.app.service.controller.ExcelConfigurationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/form_configuration")
@Slf4j
public class ExcelConfigurationController extends GenericViewControllerImpl<ExcelConfiguration, ExcelConfigurationService> {

	public 	ExcelConfigurationController(ExcelConfigurationService service) {
		page = "form_configuration";
	}
	
	@ModelAttribute("entity")
	public ExcelConfiguration getEntityOfExcelConfiguration () {
		return new ExcelConfiguration();
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getStartPageForConfiguration (ModelMap model) {
		message = null;
		setModelAttribute(model);
		return page;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String saveNewConfiguration (
			@ModelAttribute("entity") @Valid ExcelConfiguration conf,
			BindingResult result, 
			ModelMap model) {
		if(result.hasErrors()) {
			log.error(conf.toString());
			log.error(result.getAllErrors().toString());
			setModelAttribute(model);
			return page;
		}
		setModelAttribute(model);
		return page;
	}
	
	protected void setModelAttribute(ModelMap model) {
		model.addAttribute("page", page);
		model.addAttribute("message", message);
	}
	
	
	
}
