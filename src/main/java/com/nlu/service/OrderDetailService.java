package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.OrderDetailEntity;
import com.nlu.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	public List<OrderDetailEntity> getAll() {
		List<OrderDetailEntity> orderDetails = orderDetailRepository.findAll();
		return orderDetails;
	}

	public OrderDetailEntity getById(long id) {
		OrderDetailEntity orderDetail = orderDetailRepository.findById(id);
		return orderDetail;
	}

	public OrderDetailEntity insert(OrderDetailEntity orderDetailEntity) {
		OrderDetailEntity orderDetail = orderDetailRepository.save(orderDetailEntity);
		return orderDetail;
	}

	public OrderDetailEntity update(OrderDetailEntity orderDetailEntity) {
		OrderDetailEntity orderDetail = orderDetailRepository.save(orderDetailEntity);
		return orderDetail;
	}

	public void delete(long id) {
		orderDetailRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			orderDetailRepository.deleteById(id);
	}
}
