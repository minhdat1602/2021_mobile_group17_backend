package com.nlu.dto;

import java.util.List;

public class OrderStatistics {
	private List<SalesStatistics> sales;
	private List<TopUser> topUsers;
	private double max;
	private double min;
	private double average;
	private Long orderNumDay;
	private Double salesDay;
	private Double profitDay;
	private Long userNewDay;
	private Integer weekNum;
	private Integer monthNum;

	public List<TopUser> getTopUsers() {
		return topUsers;
	}

	public void setTopUsers(List<TopUser> topUsers) {
		this.topUsers = topUsers;
	}

	public List<SalesStatistics> getSales() {
		return sales;
	}

	public void setSales(List<SalesStatistics> sales) {
		this.sales = sales;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public Long getOrderNumDay() {
		return orderNumDay;
	}

	public void setOrderNumDay(Long orderNumDay) {
		this.orderNumDay = orderNumDay;
	}

	public Double getSalesDay() {
		return salesDay;
	}

	public void setSalesDay(Double salesDay) {
		this.salesDay = salesDay;
	}

	public Double getProfitDay() {
		return profitDay;
	}

	public void setProfitDay(Double profitDay) {
		this.profitDay = profitDay;
	}

	public Long getUserNewDay() {
		return userNewDay;
	}

	public void setUserNewDay(Long userNewDay) {
		this.userNewDay = userNewDay;
	}

	public Integer getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}

	public Integer getMonthNum() {
		return monthNum;
	}

	public void setMonthNum(Integer monthNum) {
		this.monthNum = monthNum;
	}

}
