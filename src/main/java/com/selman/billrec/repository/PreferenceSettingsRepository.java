package com.selman.billrec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.PreferenceSettings;

@Repository
public interface PreferenceSettingsRepository extends JpaRepository<PreferenceSettings, Long>  {
	

}
