package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.dto.Mapper;
import com.george.Productmanagementbackend.dto.requestDto.CategoryRequestDto;
import com.george.Productmanagementbackend.dto.responseDto.CategoryResponseDto;
import com.george.Productmanagementbackend.model.Category;
import com.george.Productmanagementbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        categoryRepository.save(category);
        return Mapper.categoryToCategoryResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return Mapper.categoriesToCategoryResponseDtos(categories);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("category with id: " + id + " is not present"));
    }

    @Override
    public CategoryResponseDto getCategoryById(Long categoryId) {
        Category category = getCategory(categoryId);
        return Mapper.categoryToCategoryResponseDto(category);
    }

    @Transactional
    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        Category categoryToUpdate = getCategory(id);
        categoryToUpdate.setName(categoryRequestDto.getName());
        categoryRepository.save(categoryToUpdate);
        return Mapper.categoryToCategoryResponseDto(categoryToUpdate);
    }

    @Override
    public CategoryResponseDto deleteCategory(Long id) {
        Category category = getCategory(id);
        categoryRepository.delete(category);
        return Mapper.categoryToCategoryResponseDto(category);
    }
}
