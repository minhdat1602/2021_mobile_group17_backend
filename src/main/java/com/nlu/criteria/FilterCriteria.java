package com.nlu.criteria;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilterCriteria {
	private List<Integer> brands;
	private List<Integer> collections;
	private List<Integer> categories;
}
