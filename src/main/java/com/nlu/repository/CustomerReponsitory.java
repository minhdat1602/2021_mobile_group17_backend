package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CustomerEntity;

@Repository
public interface CustomerReponsitory extends JpaRepository<CustomerEntity, Long> {
	List<CustomerEntity> findAll();

	CustomerEntity findById(long id);

	<S extends CustomerEntity> S save(S entity);

	void delete(CustomerEntity customerEntity);
}
