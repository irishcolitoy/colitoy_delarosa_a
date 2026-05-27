package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        product.setId(nextId++);
        productList.add(product);
        return product;
    }

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

    public void deleteProduct(Long id) {
        Product productToDelete = getProductById(id);
        productList.remove(productToDelete);
    }

    public List<Product> getProductsByCategory(String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPriceRange(Double min, Double max) {
        return productList.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }
}