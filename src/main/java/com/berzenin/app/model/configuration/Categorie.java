package com.berzenin.app.model.configuration;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Categorie {
	
	@Id
	private long id;
	
	private ArrayList<Cat> cats;
	
	private boolean excelData;
	private String listFromExcelBook;
	private String columnsNameOfShopId;
	private String columnsNameOfName;
	private String columnsNameOfParentCat;
	
	@Data
	class Cat {
		private int categorieId;

		private String name;
		
		private int parentCategorieId;
	}


}
