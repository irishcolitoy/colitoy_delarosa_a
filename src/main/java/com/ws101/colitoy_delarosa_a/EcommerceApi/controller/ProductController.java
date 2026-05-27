package com.ws101.colitoy_delarosa_a.EcommerceApi.controller;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import com.ws101.colitoy_delarosa_a.EcommerceApi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Product-related HTTP requests.
 * Provides endpoints for CRUD operations and filtering.
 * Base Path: <code>/api/v1/products</code>
 *
 * @author Your Name
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    /** Service dependency for business logic */
    private final ProductService productService;

    /**
     * Constructor injection for ProductService.
     *
     * @param productService Service layer dependency
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET /api/v1/products
     * Retrieves all available products.
     *
     * @return HTTP 200 OK + List of all products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * GET /api/v1/products/{id}
     * Retrieves single product by its ID.
     *
     * @param id Unique identifier of product
     * @return HTTP 200 OK + Product data
     * @exception RuntimeException Returns HTTP 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    /**
     * POST /api/v1/products
     * Creates new product entry.
     *
     * @param product Product details from request body
     * @return HTTP 201 Created + Saved product with ID
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    /**
     * PUT /api/v1/products/{id}
     * Fully updates an existing product.
     * Requires complete data.
     *
     * @param id      ID of product to update
     * @param product New complete product data
     * @return HTTP 200 OK + Updated product
     * @exception RuntimeException Returns HTTP 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * PATCH /api/v1/products/{id}
     * Partially updates product.
     * Only provided fields will change.
     *
     * @param id      ID of product to update
     * @param product Fields to update
     * @return HTTP 200 OK + Updated product
     * @exception RuntimeException Returns HTTP 404 if not found
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.patchProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    /**
     * DELETE /api/v1/products/{id}
     * Removes product permanently.
     *
     * @param id ID of product to delete
     * @return HTTP 204 No Content (Success, no body returned)
     * @exception RuntimeException Returns HTTP 404 if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * GET /api/v1/products/filter/category/{category}
     * Filters products by category name.
     *
     * @param category Category name to match
     * @return HTTP 200 OK + List of matching products
     */
    @GetMapping("/filter/category/{category}")
    public ResponseEntity<List<Product>> filterByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    /**
     * GET /api/v1/products/filter/price?min=X&max=Y
     * Filters products between minimum and maximum price.
     *
     * @param min Lower price limit
     * @param max Upper price limit
     * @return HTTP 200 OK + List of products within range
     */
    @GetMapping("/filter/price")
    public ResponseEntity<List<Product>> filterByPrice(
            @RequestParam Double min,
            @RequestParam Double max) {
        return ResponseEntity.ok(productService.getProductsByPriceRange(min, max));
    }
}
