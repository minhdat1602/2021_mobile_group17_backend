package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "review_id", referencedColumnName = "id")
	private ReviewEntity review;

	@Column(name = "url")
	private String url;

	@Column(name = "display")
	private int display;

	@Override
	public String toString() {
		return "ImageEntity [product=" + product + ", url=" + url + ", display=" + display + "]";
	}

	public ReviewEntity getReview() {
		return review;
	}

	public void setReview(ReviewEntity review) {
		this.review = review;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

}
