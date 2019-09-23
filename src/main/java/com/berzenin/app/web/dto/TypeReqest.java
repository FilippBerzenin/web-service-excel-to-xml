package com.berzenin.app.web.dto;

public enum TypeReqest {
	
	MERCH("merch"), SHOP("shop"); 
	
	private final String value;
	
	private TypeReqest(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}
}
