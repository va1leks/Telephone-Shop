package com.example.telephoneshop.service.impl;

import com.example.telephoneshop.entity.Order;
import com.example.telephoneshop.repository.OrderRepository;
import com.example.telephoneshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        order.setStatus("Pending");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
