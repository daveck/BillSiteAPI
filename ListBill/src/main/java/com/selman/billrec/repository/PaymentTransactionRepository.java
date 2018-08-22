package com.selman.billrec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.PaymentTransaction;;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long>  {
	
	List<PaymentTransaction> findByGroupFkOrderByStatusAsc(Long groupFk);
	List<PaymentTransaction> findByGroupFkAndStatus(Long groupFk, String status);

}
