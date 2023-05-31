package com.example.table.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {
	
	String save(Product product);
	
	List<Product> findAll();
}
