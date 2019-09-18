package com.berzenin.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class SmartphonesUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private long id;
	
	@NotNull
	@Size (min=1, max=100)
	private String name;
	
	@OneToMany(mappedBy="smartphonesUser", cascade = CascadeType.ALL)
	@Column(name = "users_photos")
	private Set<Photo> photos;
	
	

}
