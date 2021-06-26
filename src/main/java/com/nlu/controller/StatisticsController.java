package com.nlu.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.SalesStatistics;
import com.nlu.repository.OrderRepository;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/sales")

	public ResponseEntity<?> statisticsSales() {
		List<Object[]> result = orderRepository.findSalesStatistics();
		List<SalesStatistics> response = new ArrayList<SalesStatistics>();
		SalesStatistics st;
		if (result != null && !result.isEmpty()) {
			st = new SalesStatistics();
			for (Object[] object : result) {
				st.setMonth((Integer) object[0]);
				st.setYear((Integer) object[1]);
				st.setSales((Double) object[2]);
				st.setCount(((BigInteger) object[3]).longValue());
				response.add(st);
			}
		}
		return ResponseEntity.ok(response);
	}

}
