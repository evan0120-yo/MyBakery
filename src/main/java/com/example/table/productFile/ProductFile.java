package com.example.table.productFile;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
public class ProductFile {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "PRODUCT_FILE_ID")
    private String productFileId;
	
    @Column(name = "PRODUCT_ID")
    private String productId;
	
    @Column(name = "FILE")
    @Basic(fetch = FetchType.LAZY)
    private byte[] file;
    
    @Column(name = "THUMBNAIL")
    @Basic(fetch = FetchType.LAZY)
    private byte[] thumbnail;
    
    @CreatedDate
    @Column(name = "DT_CREATE", updatable = false, nullable = false)
    private LocalDateTime dtCreate;
    
    @LastModifiedDate
    @Column(name = "DT_UPDATE", insertable  = false)
    private LocalDateTime dtUpdate;	
}
