package com.berzenin.app.web.dto;

import java.time.LocalDate;
import java.util.List;

import com.berzenin.app.model.Merch;
import com.berzenin.app.model.Photo;

import lombok.Data;

@Data
public class PhotosFromDatesContainer {
	
	private List<Photo> photos;
	private LocalDate date;
	private Merch merch;

}
