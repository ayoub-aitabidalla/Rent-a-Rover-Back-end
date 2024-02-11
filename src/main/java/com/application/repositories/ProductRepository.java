package com.application.repositories;

import com.application.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM product p WHERE p.productName = ?1")
    Product findByName(String productName);

    @Query(value = "SELECT p FROM product p WHERE p.productId = ?1")
    Product findProductById(Integer productId);
}

