package com.nlu.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "origin_price")
	private double originPrice;

	@Column(name = "price")
	private double price;

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
	@OneToMany(mappedBy = "product")
	private Set<ImageEntity> images;

	@JsonManagedReference
	@OneToMany(mappedBy = "product")
	private Set<InventoryEntity> inventories;
	
	@JsonBackReference
	@OneToMany(mappedBy = "product")
	private Set<InputDetailEntity> inputDetails;
	
	@JsonBackReference
	@OneToMany(mappedBy = "product")
	private List<ReviewEntity> reviews;

}
