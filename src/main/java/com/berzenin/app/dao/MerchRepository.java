package com.berzenin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.Merch;

@Repository
public interface MerchRepository extends JpaRepository<Merch, Long> {

}
