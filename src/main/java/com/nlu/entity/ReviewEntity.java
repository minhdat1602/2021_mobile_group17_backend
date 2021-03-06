package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "review")
public class ReviewEntity extends BaseEntity {

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;

	@Column(name = "content")
	private String content;

	@Column(name = "rate")
	private int rate;

	@Column(name = "status")
	private int status;

	@JsonManagedReference
	@OneToMany(mappedBy = "review", targetEntity = ImageEntity.class)
	private Set<ImageEntity> images;

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Set<ImageEntity> getImages() {
		return images;
	}

	public void setImages(Set<ImageEntity> images) {
		this.images = images;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
