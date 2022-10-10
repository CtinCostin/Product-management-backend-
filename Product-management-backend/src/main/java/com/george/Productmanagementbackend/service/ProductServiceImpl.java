package com.george.Productmanagementbackend.service;

import com.george.Productmanagementbackend.exception.NotFoundException;
import com.george.Productmanagementbackend.model.Product;
import com.george.Productmanagementbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NotFoundException("The product with id " + id + "is not present"));
        return product;
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NotFoundException("The product with id: " + id + " is not present"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());

        Product updatedProduct = productRepository.save(product);

        return updatedProduct;
    }

    public List<Product> findByName(String name) {
        List<Product> productList = productRepository.findByName(name);
        if (productList.isEmpty()) {
            throw new NotFoundException("The product with name: " + name + " is not present");
        }
        return productList;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
