package com.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CartItemEntity;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
	CartItemEntity findById(long id);

	<S extends CartItemEntity> S save(S entity);

	void delete(CartItemEntity cartItemEntity);
}
