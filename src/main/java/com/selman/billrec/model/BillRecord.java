package com.selman.billrec.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BILL_RECORD")
@Getter @Setter @NoArgsConstructor
public class BillRecord extends AuditModel {

	private static final long serialVersionUID = -3646774760610772210L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long billRecordPk;
	
	private Long billFk;

	private String employeeName;

	private String employeeId;

	private BigDecimal singleDeductionAmount;

	private BigDecimal totalDeductionAmount;

	private BigDecimal previousBilledAmount;

	private BigDecimal billedAmount;

	private BigDecimal creditAmount;

	private BigDecimal billedToDate;

	private String productCode;

	private Boolean employerProvided;

	@Temporal(TemporalType.DATE)
	private Date coverageEffectiveDate;

	private String sortCode;

	private String updateStatusTypeCd;
	
	@OneToMany
	@JoinColumn(name = "billRecordFk")
	private List<Contract> contracts  = new ArrayList<Contract>();


	/*
	@ManyToOne
    @JoinColumn(name="billPk", nullable=false)
	private Bill bill;
	*/

}
