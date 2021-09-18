package com.nlu.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "home")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HomeEntity extends BaseEntity{
	private String name;
	private Integer area;
	private Integer bedroom;
	private Integer bathroom;
	private String direct;
	private Integer price;
	private String image;
	private Integer hot;
	private Integer highlight;
	private Integer active;
}
