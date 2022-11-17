package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.dto.requestDto.CategoryRequestDto;
import com.george.Productmanagementbackend.dto.responseDto.CategoryResponseDto;
import com.george.Productmanagementbackend.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getCategories();
    Category getCategory(Long categoryId);
    CategoryResponseDto getCategoryById(Long categoryId);
    CategoryResponseDto updateCategory(Long categoryId, CategoryRequestDto categoryRequestDto);
    CategoryResponseDto deleteCategory(Long categoryId);

}
