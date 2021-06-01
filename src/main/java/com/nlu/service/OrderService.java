package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.OrderEntity;
import com.nlu.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<OrderEntity> getAll() {
		List<OrderEntity> orders = orderRepository.findAll();
		return orders;
	}

	public OrderEntity getById(long id) {
		OrderEntity order = orderRepository.findById(id);
		return order;
	}

	public OrderEntity insert(OrderEntity orderEntity) {
		OrderEntity order = orderRepository.save(orderEntity);
		return order;
	}

	public OrderEntity update(OrderEntity orderEntity) {
		OrderEntity order = orderRepository.save(orderEntity);
		return order;
	}

	public void delete(long id) {
		orderRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			orderRepository.deleteById(id);
	}
}
