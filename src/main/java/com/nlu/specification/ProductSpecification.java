package com.nlu.specification;

import org.springframework.data.jpa.domain.Specification;

import com.nlu.entity.ProductEntity;

public class ProductSpecification {

	public static Specification<ProductEntity> hasName(String name) {
		return (root, query, cb) -> cb.equal(root.get("name"), name);
	}
}
