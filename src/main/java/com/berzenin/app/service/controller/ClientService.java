package com.berzenin.app.service.controller;

import org.springframework.stereotype.Service;

import com.berzenin.app.dao.ClientRepository;
import com.berzenin.app.model.Client;

@Service
public class ClientService extends GenericServiceImpl<Client, ClientRepository> {

	public ClientService(ClientRepository repository) {
		super(repository);
	}
}
