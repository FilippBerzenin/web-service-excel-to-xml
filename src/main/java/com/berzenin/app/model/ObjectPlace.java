package com.berzenin.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(exclude = "merch")
public class ObjectPlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size (min=1, max=100)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="objectPlace", cascade = CascadeType.ALL)
	@Column(name = "objects_photos")
	private Set<Photo> photos;
	
	@ManyToMany(mappedBy = "objectPlace")
	private Set<Merch> merch;
}
