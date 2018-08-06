package com.selman.billrec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.BillRelease;

@Repository
public interface BillReleaseRepository extends JpaRepository<BillRelease, Long>  {
	

}
