package com.ibm.searchorder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSearchController {
	@Autowired
	OrderService orderService;

	/**
	 * method to obtain all orders
	 * @return all the orders
	 */
	@GetMapping("/order")
	List<Order> getOrders() {
		return orderService.getOrders();
	}

	/**
	 * method to obtain a single order
	 * 
	 * @param orderId
	 * @return order details or null
	 */
	@GetMapping("/order/{id}")
	Optional<Order> getOrderById(@PathVariable("id") String orderId) {
		return orderService.getOrderById(orderId);
	}
}
