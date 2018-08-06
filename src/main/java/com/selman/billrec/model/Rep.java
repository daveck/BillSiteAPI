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
@Table(name = "REP")
@Getter @Setter @NoArgsConstructor
public class Rep extends AuditModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5392536474283156147L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long repPk;
	
	@NotBlank
	private String name;

	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String extension;
	
	
	
	
	
	

	


	
	
	
	
	

}
