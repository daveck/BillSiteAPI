package com.selman.billrec.model;


import java.math.BigDecimal;

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
@Table(name = "PREFERENCE_SETTINGS")
@Getter @Setter @NoArgsConstructor
public class PreferenceSettings extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3991186844680983702L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long preferenceSettingsPk;
	
	private Long groupFk;

	private Boolean enabled;
	
	@OneToOne
    @JoinColumn(name = "preference_type_fk")
    private PreferenceType preferenceType;
	
	
	
	
	
	
	
	

	


	
	
	
	
	

}
