package com.berzenin.app.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@Entity
@EqualsAndHashCode(exclude = {"objectPlace", "merch", "photos"})
@ToString(exclude = {"objectPlace", "merch", "photos"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Id
	private long counter;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reports")
	private ObjectPlace objectPlace;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reports")
	private Merch merch;
	
	@JsonIgnore
	@OneToMany(mappedBy="report", fetch = FetchType.LAZY)
	private Set<Photo> photos;

}
