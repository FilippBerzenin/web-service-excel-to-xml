package com.berzenin.app.model.configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Platform {
	
	@Id
	private long id;
	
	private String name;
	
	private boolean excelData;
	private String listFromExcelBook;
	private String cellFromExcelBook;
}
