package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "input_detail")
@Getter
@Setter
public class InputDetailEntity extends BaseEntity {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "input_id")
	private InputEntity input;

	@Column(name = "quantity")
	private int quantity;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@Column(name = "price")
	private double price;

	
}
