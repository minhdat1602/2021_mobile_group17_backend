package com.nlu.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.OrderDTO;
import com.nlu.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("{id}")
	public ResponseEntity<?> read(@PathParam("id") long orderId) {
		OrderDTO order = orderService.getById(orderId);
		return ResponseEntity.ok(order);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<OrderDTO> orders = orderService.getAll();
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getByUser(@PathParam("userId") Long userId, @PathParam("statusId") Long statusId) {
		List<OrderDTO> orders = orderService.getByUser(userId, statusId);
		return ResponseEntity.ok(orders);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody OrderDTO orderDTO) {
		OrderDTO order = orderService.save(orderDTO);
		return ResponseEntity.ok(order);
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody OrderDTO orderDTO) {
		OrderDTO order = orderService.save(orderDTO);
		return ResponseEntity.ok(order);
	}

	@GetMapping("/status/{id}")
	public ResponseEntity<?> getByStatus(@PathVariable("id") Long statusId) {
		List<OrderDTO> results = orderService.getByStatus(statusId);
		return ResponseEntity.ok(results);
	}
}
