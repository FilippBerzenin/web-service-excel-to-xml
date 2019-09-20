package com.berzenin.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Column(name = "data", nullable = false)
	private LocalDate data;
	
	@NotNull
	@Column(name = "time", nullable = false)
	private LocalTime time;
	
	@NotNull
	@Size(min=1, max=100)
	@Column(name = "url_photo", nullable = false)
	private String pathFoPhoto;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="objects_photos")
	private ObjectPlace objectPlace;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="merch_photos")
	private Merch merch;

}
