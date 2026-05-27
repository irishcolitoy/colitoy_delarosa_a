package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getAllOrders() {
        return orders;
    }

    public Optional<Order> getOrderById(Long id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    public Order createOrder(Order order) {
        order.setId((long) (orders.size() + 1));
        orders.add(order);
        return order;
    }

    public Order updateOrderStatus(Long id, String status) {
        Optional<Order> existing = getOrderById(id);
        if (existing.isPresent()) {
            existing.get().setStatus(status);
            return existing.get();
        }
        return null;
    }
}
