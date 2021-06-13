package com.nlu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.OrderDetailDTO;
import com.nlu.entity.OrderDetailEntity;
import com.nlu.entity.OrderEntity;
import com.nlu.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ModelMapper modelMapper;

	public List<OrderDetailEntity> getAll() {
		List<OrderDetailEntity> orderDetails = orderDetailRepository.findAll();
		return orderDetails;
	}

	public OrderDetailEntity getById(long id) {
		OrderDetailEntity orderDetail = orderDetailRepository.findById(id);
		return orderDetail;
	}
	
	public OrderDetailDTO save(OrderDetailDTO orderDetailDTO, OrderEntity orderEntity) {
		OrderDetailEntity orderDetailEntity = new OrderDetailEntity();

		if (orderDetailDTO.getId() != null) {
			OrderDetailEntity oldOrderDetailEntity = orderDetailRepository.findById(orderDetailDTO.getId()).orElseThrow();
			oldOrderDetailEntity = modelMapper.map(orderDetailDTO, OrderDetailEntity.class);
			orderDetailEntity = oldOrderDetailEntity;
		} else {
			orderDetailEntity = modelMapper.map(orderDetailDTO, OrderDetailEntity.class);
		}
		
		orderDetailEntity.setOrder(orderEntity);
		
		try {
			orderDetailEntity = orderDetailRepository.save(orderDetailEntity);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return modelMapper.map(orderDetailEntity, OrderDetailDTO.class);
	}

	public List<OrderDetailDTO> saveAll(List<OrderDetailDTO> orderDetailDTOs, OrderEntity orderEntity) {
		List<OrderDetailDTO> results = new ArrayList<OrderDetailDTO>();
		for(OrderDetailDTO orderDetailDTO : orderDetailDTOs) {
			results.add(save(orderDetailDTO, orderEntity));
		}
		return results;
	}

	public void delete(long id) {
		orderDetailRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			orderDetailRepository.deleteById(id);
	}
}
