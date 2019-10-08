package com.berzenin.app.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import antlr.collections.List;
import lombok.Data;

@Entity
@Data
public class ExcelConfiguration {

	@Id
	private long id;
	
	@Size(min=2)
	private String shop;
	@Size(min=2)
	private String name;
	@Size(min=2)
	private String company;
	@Size(min=2)
	private String url;
//	private String platform;
//	private List currencies;
//	private List categories;
//	private Map<String, String> offers;
}
