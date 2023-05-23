package com.example.table.productDesc;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class ProductDesc {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTION_DESC_ID")
    private Long ProductDescId;
	
    @Column(name = "PRODUCTION_DESC")
    private String ProductDesc;
    
    @CreatedDate
    @Column(name = "DT_CREATE", updatable = false, nullable = false)
    private LocalDateTime dtCreate;
    
    @LastModifiedDate
    @Column(name = "DT_UPDATE", insertable  = false)
    private LocalDateTime dtUpdate;	
}
