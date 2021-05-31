package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.OrderDetailEntity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
	List<OrderDetailEntity> findAll();

	OrderDetailEntity findById(long id);

	<S extends OrderDetailEntity> S save(S entity);

	void delete(OrderDetailEntity orderDetailEntity);
}
