package com.george.Productmanagementbackend.controller;

import com.george.Productmanagementbackend.model.Product;
import com.george.Productmanagementbackend.service.ProductService;
import com.george.Productmanagementbackend.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PostMapping("/products")
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
}
