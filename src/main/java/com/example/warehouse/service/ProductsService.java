package com.example.warehouse.service;

import com.example.warehouse.entity.Products;

public interface ProductsService {

    void addProduct(Products product);

    void saveProduct(Products products, String name, String brand, String description);



}
