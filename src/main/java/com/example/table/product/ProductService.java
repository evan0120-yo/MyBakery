package com.example.table.product;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void save(Product product){
		product.setDtUpdate(LocalDateTime.now());
		productRepository.save(product);
	}
}
