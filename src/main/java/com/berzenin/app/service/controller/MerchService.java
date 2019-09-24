package com.berzenin.app.service.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.MerchRepository;
import com.berzenin.app.model.Merch;
import com.berzenin.app.model.ObjectPlace;
import com.berzenin.app.web.exception.NotFoundException;

@Service
public class MerchService extends GenericServiceImpl<Merch, MerchRepository> {

	public MerchService(MerchRepository repository) {
		super(repository);
	}
	
	public Optional<Merch> getMercByLoginAndPass(String login, String pass) {
		return repository.findByLoginAndPass(login, pass);
	}
	
	public Optional<Set<ObjectPlace>> getShopsFromMerch(long id) {
		return Optional.of(repository
				.findById(id).get()
				.getObjectPlace());
	}

}
