package com.example.table.productDesc;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDescServiceImpl implements ProductDescService{

	@Autowired
	private ProductDescRepository productDescRepository;

	public String save(ProductDesc productDesc){
		productDesc.setDtUpdate(LocalDateTime.now());
		productDescRepository.save(productDesc);
		
		return productDesc.getProductDescId();
	}
}
