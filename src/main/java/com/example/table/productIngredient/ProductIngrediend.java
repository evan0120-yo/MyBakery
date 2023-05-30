package com.example.table.productIngredient;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class ProductIngrediend {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "PRODUCT_INGREDIEND_ID")
    private String productIngrediendId;
	
    @Column(name = "PRODUCT_ID")
    private String productId;
	
    @Column(name = "PRODUCT_INGREDIEND_NAME")
    private String productIngrediendName;
    
    @Column(name = "INGREDIEND_TYPE")
    private String ingrediendType;
    
    @CreatedDate
    @Column(name = "DT_CREATE", updatable = false, nullable = false)
    private LocalDateTime dtCreate;
    
    @LastModifiedDate
    @Column(name = "DT_UPDATE", insertable  = false)
    private LocalDateTime dtUpdate;	
    
    @Column(name = "SORT")
    private Integer sort;
}
