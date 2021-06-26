package com.nlu.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.OrderStatistics;
import com.nlu.dto.SalesStatistics;
import com.nlu.repository.OrderRepository;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/sales")

	public ResponseEntity<?> statisticsSales() {
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
				sales.add(st);
			}
		}
		//
		OrderStatistics result = new OrderStatistics();
		result.setSales(sales);
		result.setMin(Math.floor(min(sales) * 10) / 10);
		result.setMax(Math.floor(max(sales)));
		result.setAverage(Math.floor(avg(sales)));

		return ResponseEntity.ok(result);
	}

	private double min(List<SalesStatistics> sales) {
		double min = Integer.MIN_VALUE;
		for (SalesStatistics item : sales)
			if (min > item.getSales())
				min = item.getSales();
		return min;
	}

	private double max(List<SalesStatistics> sales) {
		double max = Integer.MAX_VALUE;
		for (SalesStatistics item : sales)
			if (max < item.getSales())
				max = item.getSales();
		return max;
	}

	private double avg(List<SalesStatistics> sales) {
		double sum = 0;
		for (SalesStatistics item : sales)

			sum += item.getSales();
		return sum / sales.size();
	}

}
