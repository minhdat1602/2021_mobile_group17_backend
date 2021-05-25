package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "stock")
public class StockEntity extends BaseEntity{
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productStock;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "size_id")
	private SizeEntity stockSize;
	
	@Column(name = "quantity")
	private Integer quantity;

	public ProductEntity getProductStock() {
		return productStock;
	}

	public void setProductStock(ProductEntity productStock) {
		this.productStock = productStock;
	}

	public SizeEntity getProductSize() {
		return stockSize;
	}

	public void setProductSize(SizeEntity stockSize) {
		this.stockSize = stockSize;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
