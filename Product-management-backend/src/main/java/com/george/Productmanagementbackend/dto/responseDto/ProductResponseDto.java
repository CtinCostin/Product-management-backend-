package com.george.Productmanagementbackend.dto.responseDto;

import lombok.Data;

@Data
public class ProductResponseDto {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String categoryName;
}
