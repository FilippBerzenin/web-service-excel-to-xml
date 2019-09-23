package com.berzenin.app.web.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.berzenin.app.model.Photo;
import com.berzenin.app.web.dto.TypeReqest;
import com.berzenin.app.service.controller.MerchService;
import com.berzenin.app.service.controller.SelectionsService;
import com.berzenin.app.web.dto.SelectionsRequest;

@Controller
@RequestMapping(value="/reports")
public class SelectionsViewController extends GenericViewControllerImpl<Photo, SelectionsService> {
	
	@Autowired
	private MerchService merchService;
	
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
		if (result.hasErrors() || !this.badDatePeriod(req.getDateStartSearch(), req.getDateFinishSearch())) {
			model.addAttribute("message", "Обратите внимание на период между датами запроса(не более 30 дней)");
			model.addAttribute("page", page);
			model.addAttribute("objectTypes", TypeReqest.values());
			return page;
		}
		if (req.getTypeReqest().equals(TypeReqest.MERCH.getValue())) {
			model.addAttribute("page", "report_merch_object");
			List<LocalDate> dates = service.getDatesBetweenTwoDates(req.getDateStartSearch(), req.getDateFinishSearch());
			model.addAttribute("listOfDates", dates);
			model.addAttribute("listOfMerchs", merchService.findAll());
			return "report_merch_object";		
		}
		model.addAttribute("page", page);
		model.addAttribute("objectTypes", TypeReqest.values());
		return page;
	}
	
	private boolean badDatePeriod (LocalDate startDate, LocalDate finishDate) {
		long p2 = ChronoUnit.DAYS.between(startDate, finishDate);		
		if (p2>0 && p2<=30) {
			return true;
		}
		return false;
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
