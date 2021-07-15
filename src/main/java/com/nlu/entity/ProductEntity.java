package com.nlu.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
public class ProductEntity extends BaseEntity {

	@Column(name = "code", unique = true)
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "origin_price")
	private Double originPrice;

	@Column(name = "price")
	private Double price;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "hot")
	private Integer isHot;

	@Column(name = "new")
	private Integer isNew;

	@Column(name = "highligh")
	private Integer isHighLigh;

	@Column(name = "material")
	private String material;

	@Column(name = "height")
	private Double height;

	@Column(name = "width")
	private Double width;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "colour")
	private String colour;

	@Column(name = "description")
	private String description;

	@Column(name = "active")
	private Integer active;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity category;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "product_type", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private List<TypeEntity> types;

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

	@JsonBackReference
	@OneToMany(mappedBy = "product", targetEntity = OrderDetailEntity.class)
	private List<OrderDetailEntity> orderDetails;

}
