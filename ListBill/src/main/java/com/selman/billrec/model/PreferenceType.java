package com.selman.billrec.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.selman.billrec.model.AuditModel;

@Entity
@Table(name = "PREFERENCE_TYPE")
@Getter @Setter @NoArgsConstructor
public class PreferenceType extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6339928261475016601L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long preferenceTypePk;
	
	@NotBlank
	private String preferenceTypeCd ;

	@NotBlank
	private String preferenceTypeDescription ;

	
	
	
	
	
	
	

	


	
	
	
	
	

}
