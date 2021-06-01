package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	List<ProductEntity> findAll();

	ProductEntity findById(long id);

	List<ProductEntity> findByCategoryId(long categoryId);

	List<ProductEntity> findByTypeId(long typeId);

	List<ProductEntity> findByCollectionId(long collectionId);

	List<ProductEntity> findByCollectionBrandId(long brandId);

	List<ProductEntity> findByCategoryIdAndTypeId(long categoryId, long typeId);

	<S extends ProductEntity> S save(S entity);

	void deleteById(Long id);

	boolean existsById(Long id);

}
