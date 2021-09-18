package com.nlu.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class HomeEntity extends BaseEntity{
	private String name;
	private Integer area;
	private Integer bedroom;
	private Integer bathroom;
	private String direct;
	private Double price;
	private String image;
	private Integer isHot;
	private Integer isHighlight;
}
