package com.ws101.colitoy_delarosa_a.EcommerceApi.controller;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import com.ws101.colitoy_delarosa_a.EcommerceApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product p = service.findById(id);

        if (p == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(p);
    }

    @GetMapping("/filter")
public List<Product> filter(
        @RequestParam String category) {

    return service.filterByCategory(category);
}

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product existing = service.findById(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        product.setId(id);

        return ResponseEntity.ok(service.save(product));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> patch(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product existing = service.findById(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        if (product.getName() != null) {
            existing.setName(product.getName());
        }

        if (product.getDescription() != null) {
            existing.setDescription(product.getDescription());
        }

        if (product.getCategory() != null) {
            existing.setCategory(product.getCategory());
        }

        if (product.getPrice() != 0) {
            existing.setPrice(product.getPrice());
        }

        if (product.getStock() != 0) {
            existing.setStock(product.getStock());
        }

        return ResponseEntity.ok(service.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        Product existing = service.findById(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}