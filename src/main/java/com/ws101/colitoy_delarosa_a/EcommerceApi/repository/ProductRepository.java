package com.ws101.colitoy_delarosa_a.EcommerceApi.repository;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Method Naming Requirement
    List<Product> findByCategoryName(String name);

    // Custom Query Requirement
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findProductsByPriceRange(
            @Param("min") double min,
            @Param("max") double max);
}