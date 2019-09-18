package com.berzenin.app.service.controller;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.PhotoRepository;
import com.berzenin.app.model.Photo;

@Service
public class SelectionsService extends GenericServiceImpl<Photo, PhotoRepository> {

	private final PhotoService photoService;	

	public SelectionsService(PhotoRepository repository, PhotoService photoService) {
		super(repository);
		this.photoService=photoService;
	}

//	public List<Exercise> findAllExercisesBetweenDatesForStudent(TimetableRequest student) {
//		return exerciseService.findByCourses_Groups_Students_IdAndDateBetween(
//				studentService.findByNameAndSurename(student.getName(), student.getSurename()).get().getId(),
//				student.getDateStartSearch(), student.getDateFinishSearch());
//	}
//	
//	public List<Exercise> findAllExercisesBetweenDatesForTeacher(TimetableRequest teacher) {
//		return exerciseService.findByCourses_Teacher_IdAndDateBetween(
//				teacherService.findByNameAndSurename(teacher.getName(), teacher.getSurename()).get().getId(),
//				teacher.getDateStartSearch(), teacher.getDateFinishSearch());
//	}
}