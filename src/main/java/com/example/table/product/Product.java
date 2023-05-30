package com.example.table.product;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
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
public class Product {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "PRODUCTION_ID")
    private String productId;
	
    @Column(name = "PRODUCTION_NAME")
    private String productName;
    
    @Column(name = "PRODUCTION_DESC_ID")
    private String ProductDescId;
    
    @CreatedDate
    @Column(name = "DT_CREATE", updatable = false, nullable = false)
    private LocalDateTime dtCreate;
    
    @LastModifiedDate
    @Column(name = "DT_UPDATE", insertable  = false)
    private LocalDateTime dtUpdate;	
}
