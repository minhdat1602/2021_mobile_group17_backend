package com.nlu.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "coupon")
public class CouponEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private double discount;

	@Column(name = "max_discount")
	private double max_discount;

	@Column(name = "max_times")
	private int max_times;

	@Column(name = "date_begin")
	private Date begin;

	@Column(name = "date_end")
	private Date end;

	@JsonBackReference
	@OneToMany(mappedBy = "coupon", targetEntity = OrderEntity.class)
	private List<OrderEntity> orders;

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

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

}
