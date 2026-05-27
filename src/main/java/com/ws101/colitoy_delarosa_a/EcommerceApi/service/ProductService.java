package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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

    public void deleteProduct(Long id) {
        Product productToDelete = getProductById(id);
        productList.remove(productToDelete);
    }
}