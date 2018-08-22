package com.selman.billrec.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>  {
	
	List<Contract> findByBillRecordFkOrderByContractNumberAsc(Long billRecordFk);

	

}
