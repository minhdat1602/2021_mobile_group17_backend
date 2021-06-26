package com.nlu.dto;

public class SalesStatistics {
	private Integer month;
	private Integer year;
	private Double sales;
	private Long count;

	public SalesStatistics(Integer month, Integer year, Double sales, Long count) {
		super();
		this.month = month;
		this.year = year;
		this.sales = sales;
		this.count = count;
	}

	public SalesStatistics() {
		super();
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getSales() {
		return sales;
	}

	public void setSales(Double sales) {
		this.sales = sales;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
