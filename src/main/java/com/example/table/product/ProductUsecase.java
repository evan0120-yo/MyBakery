package com.example.table.product;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.table.productDesc.ProductDesc;
import com.example.table.productDesc.ProductDescService;

@Component
public class ProductUsecase {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDescService productDescService;
	
	@Transactional
	public void saveProduct(ProductDTO productDTO) {
		// 1. save desc
		ProductDesc productDesc = ProductDesc.builder()
				.productDesc(productDTO.getProductDesc())
				.dtCreate(LocalDateTime.now())
				.build();
		String productDescId = productDescService.save(productDesc);
		// 2. save product
		Product product = Product.builder()
				.ProductDescId(productDescId)
				.productName(productDTO.getProductName())
				.dtCreate(LocalDateTime.now())
				.build();
		productService.save(product);
		
	}

}
