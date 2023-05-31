package com.example.table.product;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public String save(Product product){
		product.setDtUpdate(LocalDateTime.now());
		productRepository.save(product);
		
		return product.getProductId();
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
}
