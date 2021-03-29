package com.ibm.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.demo.entity.Order;
import com.ibm.demo.repo.OrderRepository;

@Service
public class OrderService { // Spring Bean:An object having special annotations in spring
	@Autowired
	OrderRepository orderRepository;// defining the dependancy as this class is dependent on repository

	@Autowired
	RestTemplate getTaxesTemplate;

	public String createOrder(Order order) {
		// call getTaxes
		Float response = getTaxesTemplate.getForObject("http://localhost:8080/getTaxes?price={price}", Float.class, order.getPrice());
		System.out.println(response);
		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public String getOrder() {
		return "order1";
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
	}

	public void deleteOrder(String orderId) {
		orderRepository.deleteById(orderId);
	}

	public Optional<Order> getOrder(String orderId) {
		return orderRepository.findById(orderId);
	}

}
