package com.example.table.product;

import javax.persistence.Column;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	@NotNull
    @Column(name = "PRODUCTION_NAME")
    private String productName;
    
    @Column(name = "PRODUCTION_DESC_ID")
    private String productDesc;
}
