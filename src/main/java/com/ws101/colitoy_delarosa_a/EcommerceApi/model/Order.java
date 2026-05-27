package com.ws101.colitoy_delarosa_a.EcommerceApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String orderNumber;
    private String customerName;
    private String shippingAddress;
    private Double totalAmount;
    private String status;
    private List<OrderItem> items;
}
