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
@Table(name = "[CASE]")
@Getter @Setter @NoArgsConstructor
public class Case extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4713503222203672802L;

	/**
	 * 
	 */

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long casePk;

	@NotBlank
	private String caseNumber;

	@NotBlank
	private String caseName;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	@Temporal(TemporalType.DATE)
	private Date terminationDate;

	
	
	
	
	

}
