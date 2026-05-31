package com.ws101.colitoy_delarosa_a.EcommerceApi.repository;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
}