package com.example.orderservice.dto;
import com.example.orderservice.entity.*;

public class OrderDTO {
    private Order order;
    private User user;
    // Getters + setters
   
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}


}