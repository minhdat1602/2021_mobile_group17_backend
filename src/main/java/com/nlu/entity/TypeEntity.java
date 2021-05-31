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
@Table(name = "type")
@Getter
@Setter
public class TypeEntity extends BaseEntity{
	
	@JsonBackReference
	@OneToMany(mappedBy = "type")
	private Set<ProductEntity> products;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private Integer active;


}
