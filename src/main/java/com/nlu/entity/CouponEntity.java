package com.nlu.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class CouponEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private double discount;

	@Column(name = "max_discount")
	private double max_discount;

	@Column(name = "max_times")
	private int max_times;

	@Column(name = "begin")
	private Date begin;

	@Column(name = "end")
	private Date end;

	@JsonBackReference
	@OneToMany(mappedBy = "coupon")
	private List<Order> orders;


	
}
