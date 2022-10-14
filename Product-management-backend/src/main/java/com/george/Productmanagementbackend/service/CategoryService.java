package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.dto.requestDto.CategoryRequestDto;
import com.george.Productmanagementbackend.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category addCategory(CategoryRequestDto categoryRequestDto);
    List<Category> getCategories();
    Category getCategory(Long id);
    Category updateCategory(Long id, CategoryRequestDto categoryRequestDto);
    Category deleteCategory(Long id);

}
