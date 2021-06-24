package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shipping")
public class ShippingEntity extends BaseEntity {

	@Column(name = "code")
	String code;

	@Column(name = "name")
	String name;

	@Column(name = "price")
	double price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	}
