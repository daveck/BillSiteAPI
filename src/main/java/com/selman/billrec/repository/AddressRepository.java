package com.selman.billrec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>  {
	
}
