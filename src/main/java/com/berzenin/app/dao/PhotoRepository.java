package com.berzenin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.Photo;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
	
//	public Optional<Photo> findByNameAndSurename(String name, String surename);

}
