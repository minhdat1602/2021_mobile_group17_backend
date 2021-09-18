//package com.nlu.repository.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.stereotype.Repository;
//
//import com.nlu.entity.BrandEntity;
//import com.nlu.entity.BrandEntity_;
//import com.nlu.entity.ProductEntity;
//import com.nlu.entity.ProductEntity_;
//
//@Repository
//public class ProductCustomRepositoryImpl {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	public List<ProductEntity> findByKeyword(String keyword) {
//
//	
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		
//		CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
//		
//		Root<ProductEntity> product = cq.from(ProductEntity.class);
//		Join<ProductEntity, BrandEntity> brand = product.join(ProductEntity_.BRAND);
//		
//		Predicate hasName = cb.like(product.get(ProductEntity_.NAME), "%"+keyword+"%");
//		Predicate hasBrand = cb.like(brand.get(BrandEntity_.NAME), "%"+keyword+"%");
//		Predicate finalPredicate = cb.or(hasName, hasBrand);
//
//		cq.where(finalPredicate);
//
//		TypedQuery<ProductEntity> query = entityManager.createQuery(cq);
//
//		return query.getResultList();
//	}
//}
