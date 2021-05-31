package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
	List<StatusEntity> findAll();

	StatusEntity findById(long id);

	<S extends StatusEntity> S save(S entity);

	void delete(StatusEntity statusEntity);
}
