package com.berzenin.app.web.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.berzenin.app.model.Photo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopsWithPhoto {
	private String name;
	private Map<LocalDate, List<Photo>> photos;
	
	public ShopsWithPhoto(String name, Map<LocalDate, List<Photo>> photos) {
		this.name = name;
		this.photos = photos;
	}
	
}
