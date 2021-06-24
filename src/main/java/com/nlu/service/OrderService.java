package com.nlu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.OrderDTO;
import com.nlu.dto.OrderDetailDTO;
import com.nlu.entity.OrderEntity;
import com.nlu.repository.OrderRepository;
import com.nlu.repository.StatusRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ModelMapper modelMapper;

	public List<OrderDTO> getAll() {
		List<OrderEntity> orders = orderRepository.findByOrderByCreatedDateDesc();
		List<OrderDTO> results = new ArrayList<>();
		for (OrderEntity order : orders) {
			results.add(mapper.map(order, OrderDTO.class));
		}
		return results;
	}

	public OrderDTO getById(Long id) {
		OrderEntity orderEntity = orderRepository.findById(id.longValue());
		OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);
		return orderDTO;
	}

	public OrderDTO save(OrderDTO orderDTO) {
		// save order begin
		OrderEntity orderEntity = new OrderEntity();

		// check for update or insert, map dto to entity for save
		if (orderDTO.getId() != null) {
			OrderEntity oldOrderEntity = orderRepository.findById(orderDTO.getId().longValue());
			oldOrderEntity = modelMapper.map(orderDTO, OrderEntity.class);
			orderEntity = oldOrderEntity;
		} else {
			orderEntity = modelMapper.map(orderDTO, OrderEntity.class);
		}
		// save and map entity for returns
		orderEntity = orderRepository.save(orderEntity);
		orderEntity.setStatus(statusRepository.findById(orderEntity.getStatus().getId().longValue()));
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
