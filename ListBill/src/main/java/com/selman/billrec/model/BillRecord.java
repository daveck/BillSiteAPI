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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

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


	@Formula(value = "(select sum(c.deduction_amount) from CONTRACT c where c.bill_record_fk = bill_record_pk)") 
	private BigDecimal deductionAmount;

	@Formula(value = "(select sum(c.bill_amount) from CONTRACT c where c.bill_record_fk = bill_record_pk)") 
	private BigDecimal billAmount;

	@Formula(value = "(select sum(c.credit_amount) from CONTRACT c where c.bill_record_fk = bill_record_pk)") 
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
