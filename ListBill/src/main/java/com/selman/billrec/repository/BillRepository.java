package com.selman.billrec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>  {
	
	List<Bill> findByBillStatusTypeCdOrderByBillDateAsc(String billStatusTypeCd);
	List<Bill> findByGroupFkOrderByBillStatusTypeCdAsc(Long groupFk);
	List<Bill> findByGroupFkAndBillStatusTypeCd(Long groupFk, String billStatusTypeCd);
	Bill findByInvoiceNumber(String invoiceNumber);

}
