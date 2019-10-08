package com.berzenin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berzenin.app.model.ExcelConfiguration;

@Repository
public interface ExcelConfigurationRepository extends JpaRepository<ExcelConfiguration, Long> {

}
