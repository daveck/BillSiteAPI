package com.selman.billrec.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.selman.billrec.model.AuditModel;

/*
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"releaseDatetime"},
        allowGetters = true)
        */

@Entity
@Table(name = "BILL_RELEASE")
@Getter @Setter @NoArgsConstructor
public class BillRelease extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7415173132093705157L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long billReleasePk;
	
	//@NotBlank
	private Long billFk;

	private String releaseUser;
	
	/*
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "releaseDatetime", nullable = false, updatable = false)
    @CreatedDate
	private Date releaseDatetime;
	*/
	
	
	
	
	
	
	

	


	
	
	
	
	

}
