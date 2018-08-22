package com.selman.billrec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Enrollee;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Long>  {
	
	List<Enrollee> findByGroupFk(Long groupFk);

}
