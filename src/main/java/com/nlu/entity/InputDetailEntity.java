package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "input_detail")
public class InputDetailEntity extends BaseEntity{

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "input_id", referencedColumnName = "id")
	private InputEntity input;

	@Column(name = "quantity")
	private int quantity;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;

	@Column(name = "price")
	private double price;

	public InputEntity getInput() {
		return input;
	}

	public void setInput(InputEntity input) {
		this.input = input;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
