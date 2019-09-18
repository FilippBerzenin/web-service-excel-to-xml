package com.berzenin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.SmartphonesUser;

@Repository
public interface UserRepository extends CrudRepository<SmartphonesUser, Long> {

}
