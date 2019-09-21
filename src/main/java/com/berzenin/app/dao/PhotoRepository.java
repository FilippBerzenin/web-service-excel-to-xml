package com.berzenin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
	
//	public Optional<Photo> findByNameAndSurename(String name, String surename);

}
