package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity extends BaseEntity {

	@JsonBackReference
	@OneToMany(mappedBy = "category")
	private Set<ProductEntity> products;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private Integer active;

}
