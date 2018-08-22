package com.selman.billrec.model;


import java.math.BigDecimal;
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
@Table(name = "PAYMENT")
@Getter @Setter @NoArgsConstructor
public class Payment extends AuditModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5159897472757220888L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentPk;
	
	private Long billFk;

	private String paymentMethodCd;
	
	private String paymentStatusCd;
	
	private BigDecimal paymentAmount;
	
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	
	
	
	
	
	

	


	
	
	
	
	

}
