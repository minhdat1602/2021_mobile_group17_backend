package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	List<OrderEntity> findAll();

	OrderEntity findById(long id);

	<S extends OrderEntity> S save(S entity);

	void delete(OrderEntity orderEntity);
}
