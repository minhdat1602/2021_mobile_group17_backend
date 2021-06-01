package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

	List<CartEntity> findAll();

	CartEntity findById(long id);

	<S extends CartEntity> S save(S entity);

	void delete(CartEntity cartEntity);

	void deleteById(Long id);


	boolean existsById(Long id);
}
