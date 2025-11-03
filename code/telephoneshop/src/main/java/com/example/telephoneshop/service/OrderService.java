package com.example.telephoneshop.service;

import com.example.telephoneshop.entity.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order);
    public List<Order> getAllOrders();
}
