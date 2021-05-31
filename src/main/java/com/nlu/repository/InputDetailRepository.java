package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.InputDetailEntity;

@Repository
public interface InputDetailRepository extends JpaRepository<InputDetailEntity, Long> {
	List<InputDetailEntity> findAll();

	InputDetailEntity findById(long id);

	<S extends InputDetailEntity> S save(S entity);

	void delete(InputDetailEntity inputDetailEntity);
}
