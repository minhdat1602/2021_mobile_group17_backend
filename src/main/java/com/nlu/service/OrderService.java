package com.nlu.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.OrderDTO;
import com.nlu.dto.OrderDetailDTO;
import com.nlu.dto.OrderStatistics;
import com.nlu.dto.SalesStatistics;
import com.nlu.dto.TopUser;
import com.nlu.dto.UserDTO;
import com.nlu.entity.OrderEntity;
import com.nlu.repository.OrderRepository;
import com.nlu.repository.StatusRepository;
import com.nlu.repository.UserRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	public OrderStatistics getMonth() {
		OrderStatistics result = new OrderStatistics();
		List<Object[]> dayStatistic = orderRepository.findDayStatistic();
		if (dayStatistic != null) {
			for (Object[] object : dayStatistic) {
				BigInteger n0 = (BigInteger) object[0];
				result.setOrderNumDay(n0.longValue());
				result.setSalesDay((Double) object[1]);
				result.setProfitDay((Double) object[2]);
				result.setUserNewDay(((BigInteger) object[3]).longValue());
			}
		}
		return result;
	}

	public List<SalesStatistics> getSales() {
		List<Object[]> salesStatistics = orderRepository.findSalesStatistics();
		List<SalesStatistics> sales = new ArrayList<SalesStatistics>();
		SalesStatistics st;
		if (salesStatistics != null && !salesStatistics.isEmpty()) {
			for (Object[] object : salesStatistics) {
				st = new SalesStatistics();
				st.setMonth((Integer) object[0]);
				st.setYear((Integer) object[1]);
				st.setSales((Double) object[2]);
				st.setCount(((BigInteger) object[3]).longValue());
				sales.add(0, st);
			}
		}
		return sales;
	}

	public List<TopUser> getTopUser() {
		List<Object[]> queries = orderRepository.findTopUser();
		List<TopUser> topUsers = new ArrayList<TopUser>();
		TopUser topUser;
		if (queries != null && !queries.isEmpty()) {
			for (Object[] object : queries) {
				topUser = new TopUser();
				long userId = (((BigInteger) object[0]).longValue());

				UserDTO userDTO = mapper.map(userRepo.findById(userId), UserDTO.class);
				topUser.setUser(userDTO);

				topUser.setTotalPrice(((Double) object[1]).longValue());
				topUser.setBuyNum(((BigInteger) object[2]).longValue());
//				st.setMonth((Integer) object[0]);
//				st.setYear((Integer) object[1]);
//				st.setSales((Double) object[2]);
//				st.setCount(((BigInteger) object[3]).longValue());
				topUsers.add(0, topUser);
			}
		}
		return topUsers;
	}

	public List<OrderDTO> getAll() {
		List<OrderEntity> orders = orderRepository.findByOrderByCreatedDateDesc();
		List<OrderDTO> results = new ArrayList<>();
		for (OrderEntity order : orders) {
			results.add(mapper.map(order, OrderDTO.class));
		}
		return results;
	}

	public List<OrderDTO> getByUser(Long userId, Long statusId) {
		List<OrderEntity> orders;
		if (statusId == null)
			orders = orderRepository.findByUserId(userId.longValue());
		else
			orders = orderRepository.findByUserIdAndStatusId(userId.longValue(), statusId.longValue());
		List<OrderDTO> results = new ArrayList<>();
		for (OrderEntity order : orders) {
			results.add(mapper.map(order, OrderDTO.class));
		}
		return results;
	}

	public List<OrderDTO> getByStatus(Long statusId) {
		List<OrderEntity> orders = orderRepository.findByStatusId(statusId);
		List<OrderDTO> results = new ArrayList<>();
		for (OrderEntity order : orders) {
			results.add(mapper.map(order, OrderDTO.class));
		}
		return results;
	}

	public OrderDTO getById(Long id) {
		OrderEntity orderEntity = orderRepository.findById(id.longValue());
		OrderDTO orderDTO = mapper.map(orderEntity, OrderDTO.class);
		return orderDTO;
	}

	public OrderDTO save(OrderDTO orderDTO) {
		// save order begin
		OrderEntity orderEntity = new OrderEntity();

		// check for update or insert, map dto to entity for save
		if (orderDTO.getId() != null) {
			OrderEntity oldOrderEntity = orderRepository.findById(orderDTO.getId().longValue());
			oldOrderEntity = mapper.map(orderDTO, OrderEntity.class);
			orderEntity = oldOrderEntity;
		} else {
			orderEntity = mapper.map(orderDTO, OrderEntity.class);
		}
		// save and map entity for returns
		orderEntity = orderRepository.save(orderEntity);
		orderEntity.setStatus(statusRepository.findById(orderEntity.getStatus().getId().longValue()));
		OrderDTO result = mapper.map(orderEntity, OrderDTO.class);
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
