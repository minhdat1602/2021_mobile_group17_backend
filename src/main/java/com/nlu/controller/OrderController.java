package com.nlu.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<?> read(@PathParam("id") long orderId){
		OrderDTO order = orderService.getById(orderId);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody OrderDTO orderDTO){
		OrderDTO order = orderService.save(orderDTO);
		return ResponseEntity.ok(order);
	}
}
