package com.nlu.dto;

import java.sql.Date;
import java.util.List;

public class CouponDTO  extends BaseDto{
	private String code;

	private double discount;

	private double max_discount;

	private int max_times;

	private Date begin;

	private Date end;

	private List<OrderDTO> orders;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getMax_discount() {
		return max_discount;
	}

	public void setMax_discount(double max_discount) {
		this.max_discount = max_discount;
	}

	public int getMax_times() {
		return max_times;
	}

	public void setMax_times(int max_times) {
		this.max_times = max_times;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}
	
}
