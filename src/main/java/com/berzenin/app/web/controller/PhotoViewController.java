package com.berzenin.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.berzenin.app.model.Photo;
import com.berzenin.app.service.controller.PhotoService;
import com.berzenin.app.service.utils.AmazonFilesController;

@Controller
@RequestMapping(value="/photo")
public class PhotoViewController extends GenericViewControllerImpl<Photo, PhotoService> {

	@Autowired
	private AmazonFilesController filesController;
	
	public 	PhotoViewController(PhotoService service) {
		page = "photo";
	}
	
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(
//    		@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
             try {
            	 filesController.copyFileForlocalDirectory(file);
                	message = "ok! Test";
                	return "Ok";
            } catch (Exception e) {
                return "Вам не удалось загрузить " +  " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " +  " потому что файл пустой.";
        }
    }
//	
//	@ModelAttribute("entityFor")
//	public Exercise getLoginForm () {
//		return new Exercise();
//	}
//	
//	@ModelAttribute("course")
//	public Course getCourseForm () {
//		return new Course();
//	}
//	
//	@Override
//	public String add(
//			@ModelAttribute("entity") Exercise entity,
//			BindingResult result, 
//			Model model) {
//		 {
//			 if (result.hasErrors()) {
//				message = "Something wrong with parameters";
//				setModelAttribute(model);
//				return page;
//			}
//			try {
//				service.add(entity);
//				message = "Entity was successful save";
//				entites = service.findAll();
//				setModelAttribute(model);
//				return page;
//			} catch (RuntimeException e) {
//				this.setModelAttributeWhenthrowException(e, model);
//				return page;
//			}
//		 }
//	}
//	
//	@Override
//	public String update(
//			@ModelAttribute("entity") @Valid Exercise entity,
//			BindingResult result, 
//			Model model) {
//		if (result.hasErrors()) {
//			message = "Something wrong with attributes";
//			setModelAttribute(model);
//			return page;
//		}
//		try {
//			service.update(entity);
//			message = "Entity was successful update";
//			entites = service.findAll();
//			setModelAttribute(model);
//			return page;
//		} catch (RuntimeException e) {
//			this.setModelAttributeWhenthrowException(e, model);
//			return page;
//		}
//	}
//	
//	@InitBinder
//	public void bindingPreparation(WebDataBinder binder) {
//	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
//	  binder.registerCustomEditor(Date.class, orderDateEditor);
//	}
//	
//	@RequestMapping(value = "/addCourse/{id}", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.OK)
//	public String addNewCourseForExercise(
//			@PathVariable("id") Long exerciseId,
//			@Valid @ModelAttribute("course") Course course, 
//			BindingResult result,
//			Model model) {
//		if (result.hasErrors()) {
//			message = "Error";
//			setModelAttribute(model);
//			return page;
//		}
//		try {
//			service.addNewCourseForExercise(exerciseId, course);;
//			message = "Course was successful added";
//			entites = service.findAll();
//			setModelAttribute(model);
//			return page;
//		} catch (RuntimeException e) {
//			this.setModelAttributeWhenthrowException(e, model);
//			return page;
//		}
//	}
//	
//	@RequestMapping(value = "/removeCourse/{id}", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.OK)
//	public String removeCourseFromExercise(
//			@PathVariable("id") Long exerciseId,
//			@Valid @ModelAttribute("course") Course course, 
//			BindingResult result,
//			Model model) {
//		if (result.hasErrors()) {
//			message = "Error";
//			setModelAttribute(model);
//			return page;
//		}
//		try {
//			service.removeCourseFromExercise(exerciseId, course);;
//			message = "Course was successful remove";
//			entites = service.findAll();
//			setModelAttribute(model);
//			return page;
//		} catch (RuntimeException e) {
//			this.setModelAttributeWhenthrowException(e, model);
//			return page;
//		}
//	}
}
