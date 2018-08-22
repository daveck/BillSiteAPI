package com.selman.billrec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Case;
import com.selman.billrec.model.Group;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long>  {
	Case findByCaseNumber(String caseNumber);
	
}
