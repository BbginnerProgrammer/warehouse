package com.example.warehouse.repository;

import com.example.warehouse.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    boolean existsByNameEqualsIgnoreCase(String name);
}
