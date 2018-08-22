package com.selman.billrec.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.selman.billrec.model.AuditModel;

@Entity
@Table(name = "PAYMENT_TRANSACTION")
@Getter @Setter @NoArgsConstructor
public class PaymentTransaction extends AuditModel {

	private static final long serialVersionUID = -8715519150144879807L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentTransactionPk;
	
	private String transactionId;

	private String userId;

	private Long groupFk;
	
	@Temporal(TemporalType.DATE)	
	private Date transactionDate;
	
	private String status;

	
	
	
	
	
	
	
	

	


	
	
	
	
	

}
