package com.nlu.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Specification<T> {
	
	Predicate toPredicate(CriteriaBuilder cb, CriteriaQuery<T> query, Root<T> root);
}
