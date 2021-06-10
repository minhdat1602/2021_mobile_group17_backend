package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CartItemEntity;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
	CartItemEntity findById(long id);

	<S extends CartItemEntity> S save(S entity);
	
	<S extends CartItemEntity> List<S> saveAll(Iterable<S> entities);

	void deleteById(Long id);


	boolean existsById(Long id);
}
