package com.ws101.colitoy_delarosa_a.EcommerceApi.repository;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}