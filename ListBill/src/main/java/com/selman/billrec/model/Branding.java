package com.selman.billrec.model;


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
@Table(name = "BRANDING")
@Getter @Setter @NoArgsConstructor
public class Branding extends AuditModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5504970902197512633L;


	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long brandingPk;
	
	private byte[] brandImage;

	private String imageTypeCd;
	
	private String brandingLine_1;

	private String brandingLine_2;

	private String brandingLine_3;

	private String brandingLine_4;
	
	
	
	
	
	
	
	

	


	
	
	
	
	

}
