package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.SizeEntity;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Long> {

	List<SizeEntity> findAll();

	SizeEntity findById(long id);

	<S extends SizeEntity> S save(S entity);

	void delete(SizeEntity sizeEntity);

	void deleteById(Long id);

	boolean existsById(Long id);
}
