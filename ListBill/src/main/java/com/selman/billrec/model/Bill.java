package com.selman.billrec.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.selman.billrec.model.AuditModel;

@Entity
@Table(name = "BILL")
@Getter @Setter @NoArgsConstructor
public class Bill extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -458269821818204309L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long billPk;

	@NotBlank
	private Long groupFk;
    	
	private Long subGroupFk;

	@NotBlank
	private String invoiceNumber;

	@NotBlank
	private String billStatusTypeCd;

	@NotBlank
	private String billingModeTypeCd;

	private BigDecimal currentAmountDue;

	private BigDecimal previousAmountDue;

	@Temporal(TemporalType.DATE)
	private Date billDate;

	@Temporal(TemporalType.DATE)
	private Date billDueDate;

	@OneToMany
	@JoinColumn(name = "billFk")
	private List<BillRecord> billRecords = new ArrayList<BillRecord>();

	@OneToMany
	@JoinColumn(name = "billFk")
	private List<Payment> Payments = new ArrayList<Payment>();
	
	@OneToOne
    @JoinColumn(name = "bill_pk")
    private BillRelease billRelease;


	
	
	
	
	

}
