package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.InputEntity;

@Repository
public interface InputRepository extends JpaRepository<InputEntity, Long> {
	List<InputEntity> findAll();

	InputEntity findById(long id);

	<S extends InputEntity> S save(S entity);

	void delete(InputEntity inputEntity);

	void deleteById(Long id);


	boolean existsById(Long id);
}
