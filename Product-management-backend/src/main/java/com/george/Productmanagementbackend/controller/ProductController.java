package com.george.Productmanagementbackend.controller;

import com.george.Productmanagementbackend.dto.requestDto.ProductRequestDto;
import com.george.Productmanagementbackend.dto.responseDto.ProductResponseDto;
import com.george.Productmanagementbackend.model.Product;
import com.george.Productmanagementbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto productResponseDto = productService.addProduct(productRequestDto);
        return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        List<ProductResponseDto> productResponseDtos = productService.getProducts();
        return new ResponseEntity<>(productResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.getProductById(id);
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductResponseDto> deleteProductById(@PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.deleteProduct(id);
        return new ResponseEntity<>(productResponseDto, HttpStatus.NO_CONTENT);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable Long id) {
        ProductResponseDto productResponseDto = productService.updateProduct(id, productRequestDto);
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }

    @PostMapping("/addCategory/{categoryId}/to/{bookId}")
    public ResponseEntity<ProductResponseDto> addCategoryToProduct(@PathVariable Long categoryId, @PathVariable Long productId) {
        ProductResponseDto productResponseDto = productService.addCategoryToProduct(productId, categoryId);
        return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/removeCategory/{categoryId}/from/{bookId}")
    public ResponseEntity<ProductResponseDto> removeCategoryFromProduct(@PathVariable Long categoryId, @PathVariable Long productId) {
        ProductResponseDto productResponseDto = productService.removeCategoryFromProduct(productId, categoryId);
        return new ResponseEntity<>(productResponseDto, HttpStatus.NO_CONTENT);
    }

}
