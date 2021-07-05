package com.nlu.dto;

import java.util.List;
import java.util.Set;

public class ProductDTO extends BaseDTO {
	private String code;

	private String name;

	private double originPrice;

	private double price;

	private double discount;

	private Integer isHot;

	private Integer isNew;

	private Integer isHighLigh;

	private String material;

	private String colour;

	private String description;

	private int active;

	private CategoryDTO category;

	private List<TypeDTO> types;

	private CollectionDTO collection;

	private Set<ImageDTO> images;

	private Set<InventoryDTO> inventories;

//	private Set<InputDetailDTO> inputDetails;

//	private List<ReviewDTO> reviews;

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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
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

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public List<TypeDTO> getTypes() {
		return types;
	}

	public void setTypes(List<TypeDTO> types) {
		this.types = types;
	}

	public CollectionDTO getCollection() {
		return collection;
	}

	public void setCollection(CollectionDTO collection) {
		this.collection = collection;
	}

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}

	public Set<InventoryDTO> getInventories() {
		return inventories;
	}

	public void setInventories(Set<InventoryDTO> inventories) {
		this.inventories = inventories;
	}

//	public Set<InputDetailDTO> getInputDetails() {
//		return inputDetails;
//	}
//
//	public void setInputDetails(Set<InputDetailDTO> inputDetails) {
//		this.inputDetails = inputDetails;
//	}

//	public List<ReviewDTO> getReviews() {
//		return reviews;
//	}
//
//	public void setReviews(List<ReviewDTO> reviews) {
//		this.reviews = reviews;
//	}

}
