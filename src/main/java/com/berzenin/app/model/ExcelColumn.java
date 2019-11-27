package com.berzenin.app.model;

import lombok.Data;

@Data
public class ExcelColumn {

	private String columnIdFromExcelStyle;
	
	private String columnsName;

	public ExcelColumn(String columnIdFromExcelStyle, String columnsName) {
		this.columnIdFromExcelStyle = columnIdFromExcelStyle;
		this.columnsName = columnsName;
	}
	
	
}
