package com.ws101.colitoy_delarosa_a.EcommerceApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class representing a Product entity in the e-commerce system.
 * Contains all necessary details about an item available for sale.
 *
 * @author Your Name
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /** Unique identifier for the product */
    private Long id;

    /**
     * Name/title of the product.
     * Rules: Required, minimum 2 characters long.
     */
    private String name;

    /**
     * Selling price of the product.
     * Rules: Must be a positive number greater than 0.
     */
    private Double price;

    /** Short description or details about the product */
    private String description;

    /**
     * Category or classification of the product.
     * Rules: Required field, cannot be empty.
     */
    private String category;

    /** URL or path to the product's display image */
    private String imageUrl;

    /**
     * Available stock quantity in inventory.
     * Rules: Must be zero or greater (non-negative).
     */
    private Integer stockQuantity;
}
