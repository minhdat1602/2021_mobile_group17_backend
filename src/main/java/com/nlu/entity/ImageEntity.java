package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity{
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productImage;
	
	@Column(name = "url")
	
	private String url;

	public ProductEntity getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductEntity productImage) {
		this.productImage = productImage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
