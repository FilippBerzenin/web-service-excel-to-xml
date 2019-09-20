package com.berzenin.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"photos", "objectPlace"})
public class Merch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "merch_id")
	private long id;
	
	@NotNull
	@Size (min=1, max=100)
	private String name;
	
	@NotNull
	@Size (min=1, max=100)
	private String login;
	
	@NotNull
	@Size (min=1, max=100)
	private String pass;
	
	@OneToMany(mappedBy="merch")
	@Column(name = "users_photos")
	private Set<Photo> photos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			  name = "merch_object", 
			  joinColumns = @JoinColumn(name = "merch_id"), 
			  inverseJoinColumns = @JoinColumn(name = "object_id"))
	private Set<ObjectPlace> objectPlace;

}
