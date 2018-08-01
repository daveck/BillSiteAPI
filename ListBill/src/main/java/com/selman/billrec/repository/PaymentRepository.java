package com.selman.billrec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selman.billrec.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>  {
	

}
