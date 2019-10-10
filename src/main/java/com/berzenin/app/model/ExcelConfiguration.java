package com.berzenin.app.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.berzenin.app.model.configuration.Categorie;
import com.berzenin.app.model.configuration.Company;
import com.berzenin.app.model.configuration.Currencies;
import com.berzenin.app.model.configuration.NameOfShop;
import com.berzenin.app.model.configuration.Platform;
import com.berzenin.app.model.configuration.Shop;
import com.berzenin.app.model.configuration.UrlForSite;

import lombok.Data;

@Entity
@Data
public class ExcelConfiguration {

	@Id
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shop shop;
	
	@OneToOne(cascade = CascadeType.ALL)
	private NameOfShop name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UrlForSite url;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Platform platform;	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Currencies currencies;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Categorie categories;
//	private Map<String, String> offers;
}
