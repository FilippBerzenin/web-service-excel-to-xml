package com.berzenin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.Merch;

@Repository
public interface MerchRepository extends CrudRepository<Merch, Long> {

}
