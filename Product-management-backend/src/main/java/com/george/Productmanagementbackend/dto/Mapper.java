package com.george.Productmanagementbackend.dto;

import com.george.Productmanagementbackend.dto.responseDto.CategoryResponseDto;
import com.george.Productmanagementbackend.dto.responseDto.ProductResponseDto;
import com.george.Productmanagementbackend.model.Category;
import com.george.Productmanagementbackend.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ProductResponseDto productToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setCategoryName(product.getCategory().getName());
        productResponseDto.setName(product.getName());

        return productResponseDto;
    }

    public static List<ProductResponseDto> productsToProductResponseDtos(List<Product> products) {
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            productResponseDtos.add(productToProductResponseDto(product));
        }
        return productResponseDtos;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        List<String> productsNames = new ArrayList<>();
        List<Product> products = category.getProducts();
        for (Product product : products) {
            productsNames.add(product.getName());
        }
        categoryResponseDto.setProductsNames(productsNames);

        return categoryResponseDto;
    }

    public static List<CategoryResponseDto> categoriesToCategoryResponseDtos(List<Category> categories) {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryResponseDtos.add(categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }


}
