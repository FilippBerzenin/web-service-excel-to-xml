package com.berzenin.app.service.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.PhotoRepository;
import com.berzenin.app.model.Photo;
import com.berzenin.app.web.dto.PhotosFromDatesContainer;

@Service
public class SelectionsService extends GenericServiceImpl<Photo, PhotoRepository> {

	public SelectionsService(PhotoRepository repository, PhotoService photoService) {
		super(repository);
	}

	public List<LocalDate> getDatesBetweenTwoDates(LocalDate dateStartSearch, LocalDate dateFinishSearch) {
	    long numOfDaysBetween = ChronoUnit.DAYS.between(dateStartSearch, dateFinishSearch); 
	    
	    List<LocalDate> list =  IntStream.iterate(0, i -> i + 1)
	      .limit(numOfDaysBetween)
	      .mapToObj(i -> dateStartSearch.plusDays(i))
	      .collect(Collectors.toList());	
	    return list;
	}

	public List<PhotosFromDatesContainer> findAllPhotosFromDatesAndMerch(List<LocalDate> dates) {
		repository.findByMerch_nameAndDate("fil", LocalDate.of(2019, 9, 23));
		return null;
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