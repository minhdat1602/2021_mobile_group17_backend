package com.nlu.dto;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
