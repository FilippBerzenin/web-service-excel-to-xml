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
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(exclude = {"merch", "photos"})
@ToString(exclude = {"merch", "photos"})
public class ObjectPlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size (min=1, max=100)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="objectPlace")
	@Column(name = "objects_photos")
	private Set<Photo> photos;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "objectPlace")
	private Set<Merch> merch;
}
