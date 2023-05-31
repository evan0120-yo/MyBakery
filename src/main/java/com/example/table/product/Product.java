package com.example.table.product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.table.productDesc.ProductDesc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraphs({
	@NamedEntityGraph(name = "Product.FindAll", attributeNodes = {
			@NamedAttributeNode(value = "productDesc")
	})
})
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "PRODUCT_ID")
    private String productId;
	
    @Column(name = "PRODUCT_NAME")
    private String productName;
    
    @Column(name = "PRODUCT_DESC_ID")
    private String ProductDescId;
    
    @CreatedDate
    @Column(name = "DT_CREATE", updatable = false, nullable = false)
    private LocalDateTime dtCreate;
    
    @LastModifiedDate
    @Column(name = "DT_UPDATE", insertable  = false)
    private LocalDateTime dtUpdate;	
    
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@JoinColumn(name="PRODUCT_DESC_ID", referencedColumnName = "PRODUCT_DESC_ID", insertable = false, updatable = false)
	private Set<ProductDesc> productDesc;
}
