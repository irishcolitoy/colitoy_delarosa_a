package com.ws101.colitoy_delarosa_a.EcommerceApi.service;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.OrderItem;
import com.ws101.colitoy_delarosa_a.EcommerceApi.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id: " + id));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem existingItem = getOrderItemById(id);
        existingItem.setQuantity(orderItemDetails.getQuantity());
        existingItem.setPrice(orderItemDetails.getPrice());
        return orderItemRepository.save(existingItem);
    }

    public void deleteOrderItem(Long id) {
        OrderItem itemToDelete = getOrderItemById(id);
        orderItemRepository.delete(itemToDelete);
    }
}