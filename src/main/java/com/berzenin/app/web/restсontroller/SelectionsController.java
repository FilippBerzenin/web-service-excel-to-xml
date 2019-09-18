package com.berzenin.app.web.restсontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berzenin.app.model.Photo;
import com.berzenin.app.service.controller.SelectionsService;

@RestController
@RequestMapping(value="/api/timetable")
public class SelectionsController extends GenericControllerImpl<Photo, SelectionsService>  {

	public SelectionsController(SelectionsService service) {
		super(service);
	}	
	
//	@GetMapping(
//			value = "/student", 
//			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseStatus(HttpStatus.OK)
//	public List<Exercise> createRequestForStudent(@RequestBody TimetableRequest entity) {
//		List<Exercise> exercises = new ArrayList<>();;
//		exercises.addAll(service.findAllExercisesBetweenDatesForStudent(entity));
//		return exercises;
//	}
//	
//	@GetMapping(
//			value = "/teacher", 
//			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseStatus(HttpStatus.OK)
//	public Set<Exercise> createRequestForTeacher(@RequestBody TimetableRequest entity) {
//		Set<Exercise> exercises = new HashSet<>();;
//		exercises.addAll(service.findAllExercisesBetweenDatesForTeacher(entity));
//		return exercises;
//	}
}
