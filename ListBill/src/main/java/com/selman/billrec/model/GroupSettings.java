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
@Table(name = "GROUP_SETTINGS")
@Getter @Setter @NoArgsConstructor
public class GroupSettings extends AuditModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 845424050942026771L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupSettingsPk;
	
	
	
	
	
	

	


	
	
	
	
	

}
