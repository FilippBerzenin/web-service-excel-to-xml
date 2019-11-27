package com.berzenin.app.model;

import java.util.List;

import lombok.Data;

@Data
public class ExcelList {

	private String id;
	private String name;
	private List<ExcelColumn> columsName;
	
	public ExcelList(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
}
