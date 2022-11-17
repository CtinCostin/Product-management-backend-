package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.dto.requestDto.ProductRequestDto;
import com.george.Productmanagementbackend.dto.responseDto.ProductResponseDto;
import com.george.Productmanagementbackend.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductResponseDto addProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProductById(Long productId);

    Product getProduct(Long productId);

    List<ProductResponseDto> getProducts();

    ProductResponseDto deleteProduct(Long productId);

    ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto);

    ProductResponseDto addCategoryToProduct(Long productId, Long categoryId);

    ProductResponseDto removeCategoryFromProduct(Long productId, Long categoryId);

}
