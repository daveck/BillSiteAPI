package com.selman.billrec.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"addDate", "modDate"},
        allowGetters = true
)
@Getter @Setter @NoArgsConstructor
public abstract class AuditModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "addDate", nullable = false, updatable = false)
    @CreatedDate
    private Date addDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modDate", nullable = false)
    @LastModifiedDate
    private Date modDate;
    
    private String addUser;
    
    private String modUser;

}