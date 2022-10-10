package com.george.Productmanagementbackend.controller;

import com.george.Productmanagementbackend.model.Product;
import com.george.Productmanagementbackend.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
