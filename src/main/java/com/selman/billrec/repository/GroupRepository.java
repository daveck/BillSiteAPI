package com.selman.billrec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Contract;
import com.selman.billrec.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>  {
	Group findByGroupNumber(String groupNumber);
	
}
