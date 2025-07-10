package com.example.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // No need to override save() or saveAll()
}
