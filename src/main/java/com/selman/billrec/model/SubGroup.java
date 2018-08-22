package com.selman.billrec.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "[SUB_GROUP]")
@Getter @Setter @NoArgsConstructor
public class SubGroup extends AuditModel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5459349509027613160L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subGoupPk;

	@NotBlank
	private Long groupFk;

	private Long subGroupFk;
    	
	@NotBlank
	private String name;

	@NotBlank
	private String description;

}
