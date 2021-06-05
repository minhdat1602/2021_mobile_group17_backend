package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
	List<BrandEntity> findAll();

	BrandEntity findById(long id);

	<S extends BrandEntity> S save(S entity);

	void deleteById(Long id);
	
	
	boolean existsById(Long id);
	
}
