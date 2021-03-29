package com.ibm.searchorder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(String orderId) {
		return orderRepository.findById(orderId);
	}

}
