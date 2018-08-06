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
@Table(name = "ADDRESS")
@Getter @Setter @NoArgsConstructor
public class Address extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417815948344668587L;
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long addressPk;
	
	private String addressLine_1;

	private String addressLine_2;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String stateCd;
	
	@NotBlank
	private String countryCd;

	@NotBlank
	private String zipCode;
	
	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	@Temporal(TemporalType.DATE)
	private Date terminationDate;
	
	private Long addressTypeFk;
	
	
	
	
	

	


	
	
	
	
	

}
