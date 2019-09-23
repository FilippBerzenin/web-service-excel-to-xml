package com.berzenin.app.web.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.berzenin.app.model.Photo;
import com.berzenin.app.model.TypeReqest;
import com.berzenin.app.service.controller.SelectionsService;
import com.berzenin.app.web.dto.SelectionsRequest;

@Controller
@RequestMapping(value="/reports")
public class SelectionsViewController extends GenericViewControllerImpl<Photo, SelectionsService> {
	
	public 	SelectionsViewController(SelectionsService service) {
		page = "reports";
	}
	
	@ModelAttribute("requestFor")
	public SelectionsRequest getLoginForm() {
		return new SelectionsRequest();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String setStartPage (Model model) {
		model.addAttribute("page", page);
		model.addAttribute("objectTypes", TypeReqest.values());
		return page;		
	}
	
	@RequestMapping(value = "/createRequest", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String getRezult (
			@ModelAttribute("requestFor") @Valid SelectionsRequest req,
			BindingResult result, 
			Model model) {
		System.out.println("start: ");
		return page;		
	}

//	@RequestMapping(value = "/createRequest/student", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public String createRequestForStudent (
//	@ModelAttribute("entityFor") @Valid SelectionsRequest entity,
//	BindingResult result, 
//	Model model) {
//		if (result.hasErrors()) {
//			message = "Error";
//			setModelAttribute(model);
//			return page;
//		} try {
//			entites = service.findAllExercisesBetweenDatesForStudent(entity);
//			message = "Search was finded";
//			setModelAttribute(model);
//			return page;
//		} catch (RuntimeException e) {
//			this.setModelAttributeWhenthrowException(e, model);
//			return page;
//		}		
//	}
//	
//	@RequestMapping(value = "/createRequest/teacher", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public String createRequestForteacher (
//	@ModelAttribute("entityFor") @Valid SelectionsRequest entity,
//	BindingResult result, 
//	Model model) {
//		if (result.hasErrors()) {
//			message = "Error";
//			setModelAttribute(model);
//			return page;
//		} try {
//			entites = service.findAllExercisesBetweenDatesForTeacher(entity);
//			message = "Search was finded";
//			setModelAttribute(model);
//			return page;
//		} catch (RuntimeException e) {
//			this.setModelAttributeWhenthrowException(e, model);
//			return page;
//		}		
//	}
}
