package com.berzenin.app.service.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berzenin.app.dao.MerchRepository;
import com.berzenin.app.model.Merch;
import com.berzenin.app.model.ObjectPlace;
import com.berzenin.app.model.Photo;

@Service
public class MerchService extends GenericServiceImpl<Merch, MerchRepository> {

	public MerchService(MerchRepository repository) {
		super(repository);
	}
	
	@Autowired
	private PhotoService photoService;
	
	public Optional<Merch> getMercByLoginAndPass(String login, String pass) {
		return repository.findByLoginAndPass(login, pass);
	}
	
	public Optional<Set<ObjectPlace>> getShopsFromMerch(long id) {
		return Optional.of(repository
				.findById(id).get()
				.getObjectPlace());
	}

	public Map<LocalDate, List<Photo>> getPhotosByDates(Merch merch, List<LocalDate> dates) {
		Map<LocalDate, List<Photo>> photoBydates = merch.getPhotos().stream()
				.filter(photo -> dates.contains(photo.getDate()))
				.collect(Collectors.groupingBy(Photo::getDate,
			        Collectors.mapping(
			        		photo -> photoService.findById(photo.getId()), Collectors.toList())));
		for (LocalDate date: dates) {
			if (!photoBydates.containsKey(date)) {
				photoBydates.put(date, new ArrayList<Photo>());
			}
		}
		SortedMap sortedMap = new TreeMap();
		sortedMap.putAll(photoBydates);
		return sortedMap;
	}

}
