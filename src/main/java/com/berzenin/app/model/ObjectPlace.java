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

import lombok.Data;

@Data
@Entity
public class ObjectPlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_place")
	private long id;
	
	@NotNull
	@Size (min=1, max=100)
	private String name;
	
//	@OneToMany(mappedBy="objectPlace", cascade = CascadeType.ALL)
//	@Column(name = "objects_photos")
//	private Set<Photo> photos;
	

}
