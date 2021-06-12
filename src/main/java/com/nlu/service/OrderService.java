package com.nlu.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.OrderDTO;
import com.nlu.dto.OrderDetailDTO;
import com.nlu.entity.OrderEntity;
import com.nlu.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ModelMapper modelMapper;

	public List<OrderEntity> getAll() {
		List<OrderEntity> orders = orderRepository.findAll();
		return orders;
	}

	public OrderDTO getById(long id) {
		OrderEntity orderEntity = orderRepository.findById(id);
		OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);
		return orderDTO;
	}

	public OrderDTO save(OrderDTO orderDTO) {
		// save order begin
		OrderEntity orderEntity = new OrderEntity();

		// check for update or insert, map dto to entity for save
		if (orderDTO.getId() != 0) {
			OrderEntity oldOrderEntity = orderRepository.findById(orderDTO.getId());
			oldOrderEntity = modelMapper.map(orderDTO, OrderEntity.class);
			orderEntity = oldOrderEntity;
		} else {
			orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
		}
		// save and map entity for returns
		orderEntity = orderRepository.save(orderEntity);
		OrderDTO result = modelMapper.map(orderEntity, OrderDTO.class);
		// save order end

		// save order details
		List<OrderDetailDTO> orderDetailResults = orderDetailService.saveAll(orderDTO.getOrderDetails(), orderEntity);

		// returns
		result.setOrderDetails(orderDetailResults);
		return result;
	}

	public void delete(long id) {
		orderRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			orderRepository.deleteById(id);
	}
}
