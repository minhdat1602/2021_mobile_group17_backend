package com.nlu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	List<OrderEntity> findAll();

	Optional<OrderEntity> findById(Long id);

	<S extends OrderEntity> S save(S entity);

	void delete(OrderEntity orderEntity);

	void deleteById(Long id);

	boolean existsById(Long id);
}
