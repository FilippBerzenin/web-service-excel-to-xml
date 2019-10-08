package com.berzenin.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@ToString
public class Client {

	
	@Id
	private long id;
	
	private String name;
}
