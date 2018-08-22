package com.selman.billrec.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTRACT")
@Getter @Setter @NoArgsConstructor
public class Contract extends AuditModel {

	private static final long serialVersionUID = -3646774760610772210L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long contractPk;
	
	private Long billRecordFk;

	private String productTypeCd;

	private String insuredFullName;

	private String insuredFirstName;

	private String insuredLastName;

	private String contractNumber;

	private String coverage;

	private BigDecimal deductionAmount;

	private BigDecimal billAmount;

	private BigDecimal creditAmount;

	private String updateStatusCd;
	
	private int number_of_deductions;

	private String sortCode;

	private String notes;

	private String sourceSystemCd;

}
