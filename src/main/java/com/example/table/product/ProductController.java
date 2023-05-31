package com.example.table.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductUsecase productUsecase;
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ProductDTO ProductDTO){
		productUsecase.saveProduct(ProductDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}
	
	
}
