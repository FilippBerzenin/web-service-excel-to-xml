package com.berzenin.app.service.controller;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.ExcelConfigurationRepository;
import com.berzenin.app.model.ExcelConfiguration;

@Service
public class ExcelConfigurationService extends GenericServiceImpl<ExcelConfiguration, ExcelConfigurationRepository> {

	public ExcelConfigurationService(ExcelConfigurationRepository repository) {
		super(repository);
	}

}
