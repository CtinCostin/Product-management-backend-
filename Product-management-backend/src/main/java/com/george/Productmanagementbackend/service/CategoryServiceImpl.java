package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.dto.requestDto.CategoryRequestDto;
import com.george.Productmanagementbackend.model.Category;
import com.george.Productmanagementbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("category with id: " + id + " is not present"));
    }

    @Override
    public Category updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        Category categoryToUpdate = getCategory(id);
        categoryToUpdate.setName(categoryRequestDto.getName());
        categoryToUpdate.setProducts(categoryRequestDto.getProductsNames());
        categoryRepository.save(categoryToUpdate);
        return categoryToUpdate;
    }

    @Override
    public Category deleteCategory(Long id) {
        Category category = getCategory(id);
        categoryRepository.delete(category);
        return category;
    }
}
