package com.berzenin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.ObjectPlace;

@Repository
public interface ObjectPlaceRepository extends CrudRepository<ObjectPlace, Long> {

	ObjectPlace findByName(String name);

}
