package com.berzenin.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

//@Entity
@Data
public class Categorie {
	
	@Id
	private long id;
	
	private int shop_id;
	
	@NotNull
	private String name;
	
	private Categorie parentCategories;

}
