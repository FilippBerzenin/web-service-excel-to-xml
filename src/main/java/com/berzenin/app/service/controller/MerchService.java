package com.berzenin.app.service.controller;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.MerchRepository;
import com.berzenin.app.model.Merch;

@Service
public class MerchService extends GenericServiceImpl<Merch, MerchRepository> {

	public MerchService(MerchRepository repository) {
		super(repository);
	}

}
