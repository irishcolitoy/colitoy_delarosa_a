package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.Order;
import com.ws101.colitoy_delarosa_a.EcommerceApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = getOrderById(id);
        existingOrder.setOrderNumber(orderDetails.getOrderNumber());
        existingOrder.setCustomerName(orderDetails.getCustomerName());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order orderToDelete = getOrderById(id);
        orderRepository.delete(orderToDelete);
    }
}