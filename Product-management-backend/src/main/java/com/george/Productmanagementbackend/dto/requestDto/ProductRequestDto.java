package com.george.Productmanagementbackend.dto.requestDto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private Double price;
    private Long categoryId;
    private String description;

}
