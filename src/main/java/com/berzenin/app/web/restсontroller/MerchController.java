package com.berzenin.app.web.restсontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.berzenin.app.model.Merch;
import com.berzenin.app.model.ObjectPlace;
import com.berzenin.app.service.controller.MerchService;

import lombok.Data;

@RestController
@RequestMapping(value = "/api/merch")
public class MerchController extends GenericControllerImpl<Merch, MerchService> {

	public MerchController(MerchService service) {
		super(service);
	}

	@GetMapping(
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/authentication")
	public List<Shop> authorizationMerchAndGetShops(
			@RequestParam("login") String login,
			@RequestParam("pass") String pass) {
		Merch merch = service.getMercByLoginAndPass(login, pass);
		List<Shop> shops = new ArrayList<>();
		for (ObjectPlace shop: merch.getObjectPlace()) {
			shops.add(new Shop(shop.getId(), shop.getName()));
		}
		return shops;
	}
	
	@Data
	private class Shop {
		
		private long id;
		private String name;
		
		public Shop(long id, String name) {
			this.id = id;
			this.name = name;
		}		
	}
}
