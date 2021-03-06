package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "type")
public class TypeEntity extends BaseEntity{

	@JsonBackReference
	@ManyToMany(mappedBy = "types", targetEntity = ProductEntity.class)
	private Set<ProductEntity> products;

	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private Integer active;

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
