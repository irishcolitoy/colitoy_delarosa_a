package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orderList = new ArrayList<>();
    private Long nextId = 1L;

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order getOrderById(Long id) {
        return orderList.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Order createOrder(Order order) {
        order.setId(nextId++);
        order.setOrderNumber("ORD-" + nextId);
        orderList.add(order);
        return order;
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = getOrderById(id);
        existingOrder.setCustomerName(orderDetails.getCustomerName());
        existingOrder.setShippingAddress(orderDetails.getShippingAddress());
        existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setTotalAmount(orderDetails.getTotalAmount());
        existingOrder.setItems(orderDetails.getItems());
        return existingOrder;
    }

    public void deleteOrder(Long id) {
        Order orderToDelete = getOrderById(id);
        orderList.remove(orderToDelete);
    }
}