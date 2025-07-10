package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.orderservice.dto.*;
import com.example.orderservice.entity.*;
import com.example.orderservice.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO getOrderWithUser(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with ID: " + orderId));

        User user = restTemplate.getForObject("http://localhost:8082/users/" + order.getUserId(), User.class);

        OrderDTO dto = new OrderDTO();
        dto.setOrder(order);
        dto.setUser(user);
        return dto;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrdersFromExternalService() {
        Order[] orders = restTemplate.getForObject("http://localhost:8084/orders".trim(), Order[].class);
        return Arrays.asList(orders);
    }
}
