package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "total_origin_price")
	private double total_sell_price;

	@Column(name = "total_discount")
	private double total_discount;

	@Column(name = "total_money")
	private double total_money;

	@Column(name = "notes")
	private String notes;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "order_status_id", referencedColumnName = "id")
	private StatusEntity status;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "coupon_id", referencedColumnName = "id")
	private CouponEntity coupon;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;

	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public CouponEntity getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponEntity coupon) {
		this.coupon = coupon;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getTotal_sell_price() {
		return total_sell_price;
	}

	public void setTotal_sell_price(double total_sell_price) {
		this.total_sell_price = total_sell_price;
	}

	public double getTotal_discount() {
		return total_discount;
	}

	public void setTotal_discount(double total_discount) {
		this.total_discount = total_discount;
	}

	public double getTotal_money() {
		return total_money;
	}

	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
