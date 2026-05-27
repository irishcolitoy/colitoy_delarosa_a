package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class handling business logic and data management for Products.
 * Acts as a bridge between Controller and stored data.
 * Uses in-memory storage (List<Product>).
 *
 * @author Your Name
 * @see Product
 */
@Service
public class ProductService {

    /** In-memory list acting as temporary database storage */
    private final List<Product> productList = new ArrayList<>();

    /** Auto-increment counter for generating unique IDs */
    private Long nextId = 1L;

    /**
     * Retrieves all products currently stored.
     *
     * @return List of all Product objects; empty list if none exist.
     */
    public List<Product> getAllProducts() {
        return productList;
    }

    /**
     * Finds a specific product using its ID.
     *
     * @param id Unique identifier of the product to find
     * @return Found Product object
     * @throws RuntimeException If no product matches the given ID
     */
    public Product getProductById(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    /**
     * Creates and saves a new product.
     * Automatically assigns a unique ID.
     *
     * @param product Product object containing details to save
     * @return Saved Product with generated ID
     */
    public Product createProduct(Product product) {
        product.setId(nextId++);
        productList.add(product);
        return product;
    }

    /**
     * Fully updates an existing product.
     * Replaces all fields with new provided data.
     *
     * @param id      ID of product to update
     * @param product New complete product data
     * @return Updated Product object
     * @throws RuntimeException If product ID does not exist
     */
    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setImageUrl(productDetails.getImageUrl());
        existingProduct.setStockQuantity(productDetails.getStockQuantity());
        return existingProduct;
    }

    /**
     * Partially updates an existing product.
     * Only updates fields that are provided/non-null, keeps others unchanged.
     *
     * @param id      ID of product to update
     * @param product Product data containing only fields to change
     * @return Updated Product object
     * @throws RuntimeException If product ID does not exist
     */
    public Product patchProduct(Long id, Product productDetails) {
        Product existingProduct = getProductById(id);
        if (productDetails.getName() != null)
            existingProduct.setName(productDetails.getName());
        if (productDetails.getPrice() != null)
            existingProduct.setPrice(productDetails.getPrice());
        if (productDetails.getDescription() != null)
            existingProduct.setDescription(productDetails.getDescription());
        if (productDetails.getCategory() != null)
            existingProduct.setCategory(productDetails.getCategory());
        if (productDetails.getImageUrl() != null)
            existingProduct.setImageUrl(productDetails.getImageUrl());
        if (productDetails.getStockQuantity() != null)
            existingProduct.setStockQuantity(productDetails.getStockQuantity());
        return existingProduct;
    }

    /**
     * Removes a product from storage.
     *
     * @param id ID of product to delete
     * @throws RuntimeException If product ID does not exist
     */
    public void deleteProduct(Long id) {
        Product productToDelete = getProductById(id);
        productList.remove(productToDelete);
    }

    /**
     * Filters products by exact category match.
     *
     * @param category Category name to filter by (case-insensitive)
     * @return List of products belonging to specified category
     */
    public List<Product> getProductsByCategory(String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    /**
     * Filters products within a specific price range.
     *
     * @param min Minimum price limit (inclusive)
     * @param max Maximum price limit (inclusive)
     * @return List of products where price is between min and max
     */
    public List<Product> getProductsByPriceRange(Double min, Double max) {
        return productList.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }
}