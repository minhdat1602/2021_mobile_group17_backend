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
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@Column(name = "hot")
	private Integer isHot;

	@Column(name = "new")
	private Integer isNew;
	
	@Column(name = "material")
	private String material;
	
	@Column(name = "colour")
	private String colour;

	@Column(name = "description")
	private String description;

	@Column(name = "avtive")
	private int active;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "type_id")
	private TypeEntity type;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "collection_id")
	private CollectionEntity collection;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "productImage")
	private Set<ImageEntity> images;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "productStock")
	private Set<StockEntity> stocks;

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

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public CollectionEntity getCollection() {
		return collection;
	}

	public void setCollection(CollectionEntity collection) {
		this.collection = collection;
	}

	public Set<ImageEntity> getImages() {
		return images;
	}

	public void setImages(Set<ImageEntity> images) {
		this.images = images;
	}

	public Set<StockEntity> getStocks() {
		return stocks;
	}

	public void setStocks(Set<StockEntity> stocks) {
		this.stocks = stocks;
	}
	
	
}
