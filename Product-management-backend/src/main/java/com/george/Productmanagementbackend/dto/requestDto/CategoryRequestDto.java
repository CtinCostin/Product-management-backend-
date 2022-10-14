package com.george.Productmanagementbackend.dto.requestDto;

import com.george.Productmanagementbackend.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryRequestDto {

    private String name;
    private List<Product> productsNames;

}
