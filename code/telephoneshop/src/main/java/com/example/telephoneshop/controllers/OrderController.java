package com.example.telephoneshop.controllers;


import com.example.telephoneshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("telshop/")
public class OrderController {
    public OrderService orderService;


}
