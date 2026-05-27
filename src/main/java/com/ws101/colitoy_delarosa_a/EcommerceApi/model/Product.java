package com.ws101.colitoy_delarosa_a.EcommerceApi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private Double price;

    private String description;
    private String category;
    private String imageUrl;

    @Positive(message = "Stock quantity must be greater than zero")
    private Integer stockQuantity;
}