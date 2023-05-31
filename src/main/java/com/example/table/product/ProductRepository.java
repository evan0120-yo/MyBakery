package com.example.table.product;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {

    @EntityGraph(value = "Product.FindAll")
    @Query("SELECT p "
            + " FROM Product p "
            + " LEFT JOIN p.productDesc pd "
            )
	List<Product> findAll();
}
