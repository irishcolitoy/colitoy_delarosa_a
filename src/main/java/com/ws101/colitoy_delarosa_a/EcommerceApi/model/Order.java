package com.ws101.colitoy_delarosa_a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private String status; // hal: PENDING, SHIPPED, DELIVERED, CANCELLED
    private Double totalAmount;
    private List<OrderItem> items;
}
