package com.nlu.dto;

import java.util.List;

public class OrderStatistics {
	private List<SalesStatistics> sales;
	private double max;
	private double min;
	private double average;
	private int dayNum;
	private int weekNum;
	private int monthNum;

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

	public void setAverage(int average) {
		this.average = average;
	}

	public int getDayNum() {
		return dayNum;
	}

	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

	public int getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(int weekNum) {
		this.weekNum = weekNum;
	}

	public int getMonthNum() {
		return monthNum;
	}

	public void setMonthNum(int monthNum) {
		this.monthNum = monthNum;
	}

}
