package com.ws101.colitoy_delarosa_a.EcommerceApi.controller;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import com.ws101.colitoy_delarosa_a.EcommerceApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
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
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}