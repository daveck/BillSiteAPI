package com.selman.billrec.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.BillRecord;

@Repository
public interface BillRecordRepository extends JpaRepository<BillRecord, Long>  {
	
	List<BillRecord> findByBillFkOrderByEmployeeIdAsc(Long billFk);
	//Page<BillRecord> findByBillFk(Long billFk, Pageable pageable);

	

}
