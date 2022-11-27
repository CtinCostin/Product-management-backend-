package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.dto.Mapper;
import com.george.Productmanagementbackend.dto.requestDto.ProductRequestDto;
import com.george.Productmanagementbackend.dto.responseDto.ProductResponseDto;
import com.george.Productmanagementbackend.model.Category;
import com.george.Productmanagementbackend.model.Product;
import com.george.Productmanagementbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Transactional
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
        if (productRequestDto.getCategoryId() == null) {
            throw new IllegalArgumentException("product should have a category");
        }
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        Category category = categoryService.getCategory(productRequestDto.getCategoryId());
        product.setCategory(category);

        Product product1 = productRepository.save(product);
        return Mapper.productToProductResponseDto(product1);

    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        Product product = getProduct(productId);
        return Mapper.productToProductResponseDto(product);
    }

    @Override
    public Product getProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalArgumentException("cannot find product with id: " + productId));
        return product;
    }

    @Override
    public List<ProductResponseDto> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return Mapper.productsToProductResponseDtos(products);

    }

    @Override
    public ProductResponseDto deleteProduct(Long productId) {
        Product product = getProduct(productId);
        productRepository.delete(product);
        return Mapper.productToProductResponseDto(product);
    }

    @Transactional
    @Override
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto) {
        Product productToEdit = getProduct(productId);
        productToEdit.setName(productRequestDto.getName());
        if (productRequestDto.getCategoryId() != null) {
            Category category = categoryService.getCategory(productRequestDto.getCategoryId());
            productToEdit.setCategory(category);
        }
        productToEdit.setDescription(productRequestDto.getDescription());
        productToEdit.setPrice(productRequestDto.getPrice());
        return Mapper.productToProductResponseDto(productToEdit);
    }

    @Override
    public ProductResponseDto addCategoryToProduct(Long productId, Long categoryId) {
        Product product = getProduct(productId);
        Category category = categoryService.getCategory(categoryId);
        if (Objects.nonNull(product.getCategory())) {
            throw new IllegalArgumentException("product already has a category");
        }
        product.setCategory(category);

        return Mapper.productToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto removeCategoryFromProduct(Long productId, Long categoryId) {
        Product product = getProduct(productId);
        Category category = categoryService.getCategory(categoryId);
        if (!(Objects.nonNull(product.getCategory()))) {
            throw new IllegalArgumentException("product does not have a category to delete");
        }
        product.setCategory(null);

        return Mapper.productToProductResponseDto(product);
    }


}
