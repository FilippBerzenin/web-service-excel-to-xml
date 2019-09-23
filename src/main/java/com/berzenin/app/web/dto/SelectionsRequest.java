package com.berzenin.app.web.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SelectionsRequest {	
	
	private String typeReqest;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateStartSearch;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFinishSearch;
	
	public SelectionsRequest() {
	}

	public SelectionsRequest(String typeReqest, LocalDate dateStartSearch, LocalDate dateFinishSearch) {
		this.typeReqest = typeReqest;
		this.dateStartSearch = dateStartSearch;
		this.dateFinishSearch = dateFinishSearch;
	}
}
