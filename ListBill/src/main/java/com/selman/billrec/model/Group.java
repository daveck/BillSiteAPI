package com.selman.billrec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "[GROUP]")
@Getter @Setter @NoArgsConstructor
public class Group extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4713503222203672802L;

	/**
	 * 
	 */

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long groupPk;

	private Long caseFk;
    	
	@OneToOne
    @JoinColumn(name = "branding_fk")
	private Branding branding;

	/*
	@OneToOne
    @JoinColumn(name = "group_settings_fk")
	private GroupSettings groupSettings;
	*/
	
	@OneToOne
    @JoinColumn(name = "address_fk")
    private Address address;

	@OneToOne
    @JoinColumn(name = "rep_fk")
	private Rep rep;

	private String groupNumber;

	private String groupName;

	@Temporal(TemporalType.DATE)
	private Date effectiveDate;

	@Temporal(TemporalType.DATE)
	private Date terminationDate;
	
	@OneToMany
	@JoinColumn(name = "groupFk")
	private List<PreferenceSettings> preferenceSettings = new ArrayList<PreferenceSettings>();

	@OneToMany
	@JoinColumn(name = "groupFk")
	private List<Bill> bills = new ArrayList<Bill>();


	
	
	
	
	

}
