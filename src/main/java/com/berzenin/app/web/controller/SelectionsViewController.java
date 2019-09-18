package com.berzenin.app.web.controller;

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
import com.berzenin.app.service.controller.SelectionsService;
import com.berzenin.app.web.dto.SelectionsRequest;

@Controller
@RequestMapping(value="/timetable")
public class SelectionsViewController extends GenericViewControllerImpl<Photo, SelectionsService> {
	
	public 	SelectionsViewController(SelectionsService service) {
		page = "timetable";
	}
	
	@ModelAttribute("entityFor")
	public SelectionsRequest getLoginForm() {
		return new SelectionsRequest();
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String setStartPage () {
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
