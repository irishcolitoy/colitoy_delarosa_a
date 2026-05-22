package com.ws101.colitoy_delarosa_a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long id;
    private Product product;
    private Integer quantity;
    private Double subtotal;
}
