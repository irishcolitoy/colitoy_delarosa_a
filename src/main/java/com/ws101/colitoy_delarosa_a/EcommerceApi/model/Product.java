package com.ws101.colitoy_delarosa_a.EcommerceApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private String imageUrl;
    private Integer stockQuantity;
}
