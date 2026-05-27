package com.ws101.colitoy_delarosa_a.EcommerceApi.controller;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import com.ws101.colitoy_delarosa_a.EcommerceApi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam String filterType,
            @RequestParam String filterValue) {

        List<Product> filteredProducts = switch (filterType.toLowerCase()) {
            case "category" -> productService.filterByCategory(filterValue);
            case "name" -> productService.filterByName(filterValue);
            case "price" -> {
                double priceValue = Double.parseDouble(filterValue);
                yield productService.filterByPriceRange(priceValue, priceValue);
            }
            default -> List.of();
        };

        return ResponseEntity.ok(filteredProducts);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> partiallyUpdateProduct(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return productService.getProductById(id)
                .map(existingProduct -> {
                    if (updates.containsKey("name")) {
                        existingProduct.setName((String) updates.get("name"));
                    }
                    if (updates.containsKey("description")) {
                        existingProduct.setDescription((String) updates.get("description"));
                    }
                    if (updates.containsKey("price")) {
                        existingProduct.setPrice(Double.valueOf(updates.get("price").toString()));
                    }
                    if (updates.containsKey("category")) {
                        existingProduct.setCategory((String) updates.get("category"));
                    }
                    if (updates.containsKey("stockQuantity")) {
                        existingProduct.setStockQuantity(Integer.valueOf(updates.get("stockQuantity").toString()));
                    }
                    if (updates.containsKey("imageUrl")) {
                        existingProduct.setImageUrl((String) updates.get("imageUrl"));
                    }
                    return ResponseEntity.ok(existingProduct);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}