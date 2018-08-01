package com.selman.billrec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.SubGroup;

@Repository
public interface SubGroupRepository extends JpaRepository<SubGroup, Long>  {
	

}
