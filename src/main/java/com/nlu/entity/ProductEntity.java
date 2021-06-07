package com.nlu.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "origin_price")
	private double originPrice;

	@Column(name = "price")
	private double price;

	@Column(name = "discount")
	private double discount;

	@Column(name = "hot")
	private Integer isHot;

	@Column(name = "new")
	private Integer isNew;

	@Column(name = "highligh")
	private Integer isHighLigh;

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
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity category;

	@JsonManagedReference
	@ManyToOne
	@JoinTable(name = "product_type", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private TypeEntity type;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "collection_id", referencedColumnName = "id")
	private CollectionEntity collection;

	@JsonManagedReference
	@OneToMany(mappedBy = "product", targetEntity = ImageEntity.class)
	private Set<ImageEntity> images;

	@JsonManagedReference
	@OneToMany(mappedBy = "product", targetEntity = InventoryEntity.class)
	private Set<InventoryEntity> inventories;

	@JsonBackReference
	@OneToMany(mappedBy = "product", targetEntity = InputDetailEntity.class)
	private Set<InputDetailEntity> inputDetails;

	@JsonBackReference
	@OneToMany(mappedBy = "product", targetEntity = ReviewEntity.class)
	private List<ReviewEntity> reviews;

	public String getCode() {
		return code;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
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

	public double getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
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

	public Integer getIsHighLigh() {
		return isHighLigh;
	}

	public void setIsHighLigh(Integer isHighLigh) {
		this.isHighLigh = isHighLigh;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
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

	public TypeEntity getType() {
		return type;
	}

	public void setType(TypeEntity type) {
		this.type = type;
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

	public Set<InventoryEntity> getInventories() {
		return inventories;
	}

	public void setInventories(Set<InventoryEntity> inventories) {
		this.inventories = inventories;
	}

	public Set<InputDetailEntity> getInputDetails() {
		return inputDetails;
	}

	public void setInputDetails(Set<InputDetailEntity> inputDetails) {
		this.inputDetails = inputDetails;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

}
