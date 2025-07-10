package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.entity.Order; // ✅ Correct import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        return orderService.getOrderWithUser(id);
    }
}
