package com.selman.billrec.model;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.selman.billrec.model.AuditModel;

@Entity
@Table(name = "ENROLLEE")
@Getter @Setter @NoArgsConstructor
public class Enrollee extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1148243540192573086L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long enrolleePk;
	
	@NotBlank
	private String employeeName;
	
	@NotBlank
	private String employeeId;
	
	private String employeeSsn;
	
	@NotBlank
	private String insuredName;
	
	//@NotBlank
	private Long groupFk;
	
	@NotBlank
	private String coverageTypeCd;
	
	private BigDecimal coverageAmount;
	
	@NotBlank
	private String enrolleeStatusTypeCd;
	
	
	
	
	
	

	


	
	
	
	
	

}
