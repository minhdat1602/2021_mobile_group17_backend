package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order")
public class OrderEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "total_origin_price")
	private double total_sell_price;

	@Column(name = "total_discount")
	private double total_discount;

	@Column(name = "total_money")
	private double total_money;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private StatusEntity status;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "coupon_id", referencedColumnName = "id")
	private CouponEntity coupon;

	@Column(name = "note")
	private String note;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;

	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;

}
