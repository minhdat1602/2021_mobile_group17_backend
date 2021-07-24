package com.nlu.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coupon")
@Setter
@Getter
public class CouponEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private double discount;

	@Column(name = "date_begin")
	private Date begin;

	@Column(name = "date_end")
	private Date end;

	@Column(name = "type")
	private Integer type;

	@JsonBackReference
	@OneToMany(mappedBy = "coupon", targetEntity = OrderEntity.class)
	private List<OrderEntity> orders;

}
