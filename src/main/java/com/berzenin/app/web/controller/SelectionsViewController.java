package com.berzenin.app.web.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.berzenin.app.model.Photo;
import com.berzenin.app.service.controller.MerchService;
import com.berzenin.app.service.controller.PhotoService;
import com.berzenin.app.service.controller.SelectionsService;
import com.berzenin.app.web.dto.MerchWithPhoto;
import com.berzenin.app.web.dto.SelectionsRequest;
import com.berzenin.app.web.dto.TypeReqest;

import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping(value = "/reports")
public class SelectionsViewController extends GenericViewControllerImpl<Photo, SelectionsService> {

	@Autowired
	private MerchService merchService;

	@Autowired
	private PhotoService photoService;

	public SelectionsViewController(SelectionsService service) {
		page = "reports";
	}

	@ModelAttribute("requestFor")
	public SelectionsRequest getLoginForm() {
		return new SelectionsRequest();
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String setStartPage(Model model) {
		model.addAttribute("page", page);
		model.addAttribute("objectTypes", TypeReqest.values());
		return page;
	}

	@RequestMapping(value = "/merch_report", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String getRezultForMerch(@RequestParam("photos") String photo, Model model) {
		List<Photo> photos = new ArrayList<>();
		Pattern pattern = Pattern.compile("id=.+?\\D");
		Matcher matcher = pattern.matcher(photo);
		while (matcher.find()) {
			long i = Long.parseLong(photo.substring(matcher.start() + 3, matcher.end() - 1));
			photos.add(photoService.findById(i));
		}
		model.addAttribute("potos_list", photos);
		model.addAttribute("central_image", photos.get(0));
		
		return "photos_merch";
	}

	@RequestMapping(value = "/createRequest", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String getRezult(@ModelAttribute("requestFor") @Valid SelectionsRequest req, BindingResult result,
			Model model) {
		if (result.hasErrors() || !this.badDatePeriod(req.getDateStartSearch(), req.getDateFinishSearch())) {
			model.addAttribute("message", "Обратите внимание на период между датами запроса(не более 30 дней)");
			model.addAttribute("page", page);
			model.addAttribute("objectTypes", TypeReqest.values());
			return page;
		}
		if (req.getTypeReqest().equals(TypeReqest.MERCH.getValue())) {
			model.addAttribute("page", "report_merch");
			List<LocalDate> dates = service.getDatesBetweenTwoDates(req.getDateStartSearch(),
					req.getDateFinishSearch());
			List<MerchWithPhoto> merchs = merchService.findAll().stream()
					.map(m -> new MerchWithPhoto(m.getName(), merchService.getPhotosByDates(m, dates)))
					.collect(Collectors.toList());
			model.addAttribute("listOfDates", dates);
			model.addAttribute("listOfMerchsPhoto", merchs);
			return "report_merch";
		}
		model.addAttribute("page", page);
		model.addAttribute("objectTypes", TypeReqest.values());
		return page;
	}

	private boolean badDatePeriod(LocalDate startDate, LocalDate finishDate) {
		long p2 = ChronoUnit.DAYS.between(startDate, finishDate);
		if (p2 > 0 && p2 <= 30) {
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
