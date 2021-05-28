package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "collection")
public class CollectionEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity collectionBrand;
	
	@JsonBackReference
	@OneToMany(mappedBy = "collection")
	private Set<ProductEntity> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BrandEntity getCollectionBrand() {
		return collectionBrand;
	}

	public void setCollectionBrand(BrandEntity collectionBrand) {
		this.collectionBrand = collectionBrand;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
}
