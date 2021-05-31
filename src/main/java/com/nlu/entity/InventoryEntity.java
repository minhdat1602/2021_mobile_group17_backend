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
@Table(name = "inventory")
@Getter
@Setter
public class InventoryEntity extends BaseEntity {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "size_id")
	private SizeEntity size;

	@Column(name = "quantity")
	private Integer quantity;


}
