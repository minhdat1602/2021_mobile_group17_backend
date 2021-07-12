package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.OrderStatistics;
import com.nlu.dto.SalesStatistics;
import com.nlu.dto.TopUser;
import com.nlu.service.OrderService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/order")
	public ResponseEntity<?> statisticsSales() {
		OrderStatistics result = orderService.getMonth();

		List<SalesStatistics> sales = orderService.getSales();
		result.setSales(sales);

		List<TopUser> topUsers = orderService.getTopUser();
		result.setTopUsers(topUsers);

		int min = (int) min(sales);
		int max = (int) max(sales);
		int avg = (int) avg(sales);
		result.setMin(min);
		result.setMax(max);
		result.setAverage(avg);

		return ResponseEntity.ok(result);
	}

	private double min(List<SalesStatistics> sales) {
		double min = Integer.MAX_VALUE;
		for (SalesStatistics item : sales)
			if (min > item.getSales())
				min = item.getSales();
		return min;
	}

	private double max(List<SalesStatistics> sales) {
		double max = Integer.MIN_VALUE;
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
