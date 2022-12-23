package com.example.warehouse.service.ServiceImpl;

import com.example.warehouse.entity.Products;
import com.example.warehouse.repository.ProductsRepository;
import com.example.warehouse.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
 public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public void addProduct(Products product) {
        if(!productsRepository.existsByNameEqualsIgnoreCase(product.getName())) { productsRepository.save(product); }
    }

    @Override
    public void saveProduct(Products products,String name, String brand, String description) {
        products.setName(name);
        products.setBrand(brand);
        products.setDescription(description);
        productsRepository.save(products);
    }


}
