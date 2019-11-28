package com.berzenin.app.service.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.berzenin.app.dao.ExcelConfigurationRepository;
import com.berzenin.app.model.ExcelColumn;
import com.berzenin.app.model.ExcelConfiguration;
import com.berzenin.app.model.ExcelList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExcelFileService extends GenericServiceImpl<ExcelConfiguration, ExcelConfigurationRepository> {

	private Workbook workbook;
	
	public ExcelFileService(ExcelConfigurationRepository repository) {
		super(repository);
	}
	
	public Optional<List<ExcelList>> getAllSheetName (File excelFile) {
		workbook  = this.createExcelWorkbook(excelFile);
		List<ExcelList> excelLists = parseExcelWorkbookFromSheet(workbook);
		excelLists.forEach(listName -> {
			listName.setColumsName(getColumsNameFromList(workbook.getSheet(listName.getName())));
		});
		excelLists.forEach(list -> {
			System.out.println("Lists: "+list.getName());
			list.getColumsName().forEach(cell -> {
				System.out.println("Cell: "+cell.getColumnsName());
			});
			
		});
		return Optional.of(excelLists);
	}
	
	
	private List<ExcelColumn> getColumsNameFromList (Sheet sheet) {
		Row row = sheet.getRow(0);
		List<ExcelColumn> excelColumn = new LinkedList<>();
		row.forEach(cell -> {
			if (!this.getCellValue(cell).isEmpty() || this.getCellValue(cell).length() != 0) {
				excelColumn.add(new ExcelColumn(
						Integer.toString(cell.getColumnIndex()), 
						cell.getStringCellValue()));
			}
		});
		return excelColumn;
	}
	
	private String getCellValue (Cell cell) {
		if (cell.getCellTypeEnum().equals(cell.CELL_TYPE_STRING)) {
			return cell.getStringCellValue();
		} if (cell.getCellTypeEnum().equals(cell.CELL_TYPE_NUMERIC)) {
			return Double.toString(cell.getNumericCellValue());
		}
		return "";
	}
	
	private int getLastColumnIndexFromRow (Row row) {
		return (int)row.getLastCellNum();
	}
	
//	public Optional<List<ExcelColumn>> getAllColumnsName (File excelFile) {
//		
//		return Optional.empty();
//	}
	
	private Workbook createExcelWorkbook(File excelFile) {	
		try {
			return WorkbookFactory.create(excelFile);
		} catch (InvalidFormatException | IOException | RuntimeException e) {
			log.error("Error from creating excel workbook "+excelFile.getName());
			log.error(e.getStackTrace().toString());		
		} 
		return null;
	}
	
	private List<ExcelList> parseExcelWorkbookFromSheet(Workbook workbook) {
		List<ExcelList> listsName = new LinkedList<>();
		workbook.forEach(list -> {
			listsName.add(new ExcelList("empty", list.getSheetName()));
			log.info(list.toString());
		});
		return listsName;		
	}
}

