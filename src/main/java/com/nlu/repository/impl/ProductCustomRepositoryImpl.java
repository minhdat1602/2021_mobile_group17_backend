package com.nlu.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.nlu.entity.BrandEntity;
import com.nlu.entity.BrandEntity_;
import com.nlu.entity.ProductEntity;
import com.nlu.entity.ProductEntity_;

@Repository
public class ProductCustomRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ProductEntity> findByKeyword(String keyword) {

		// which we can use to create different parts of the query
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// SELECT: which describes what we want to do in the query, Also, it declares
		// the type of a row in the result
		CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
		// FROM: we declare the starting point of the query (Book entity)
		Root<ProductEntity> product = cq.from(ProductEntity.class);
		Join<ProductEntity, BrandEntity> brand = product.join(ProductEntity_.BRAND);
		// Điều kiện: we create predicates against our Product Entity
		// ProductEntity_ là metamodel jpa 2.0 trong criteria api
		Predicate hasName = cb.like(brand.get(ProductEntity_.NAME), "%"+keyword+"%");
		Predicate hasBrand = cb.like(brand.get(BrandEntity_.NAME), "%"+keyword+"%");
		Predicate finalPredicate = cb.or(hasName, hasBrand);

		// WHERE: We apply predicates to our CriteriaQuery.
		cq.where(finalPredicate);

		// Thực hiện câu truy vấn
		TypedQuery<ProductEntity> query = entityManager.createQuery(cq);

		return query.getResultList();
	}
}
