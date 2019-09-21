package com.berzenin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.ObjectPlace;

@Repository
public interface ObjectPlaceRepository extends JpaRepository<ObjectPlace, Long> {

	ObjectPlace findByName(String name);

}
