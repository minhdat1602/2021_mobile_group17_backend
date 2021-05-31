package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order")
@Getter
@Setter
public class OrderEntity extends BaseEntity {
	
	@Column(name = "code")
	private String code;

	@Column(name = "total_origin_price")
	private double total_sell_price;

	@Column(name = "total_discount")
	private double total_discount;

	@Column(name = "total_money")
	private double total_money;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private StatusEntity status;

	@ManyToOne
	@JoinColumn(name = "coupon_id")
	private CouponEntity coupon;

	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

}
