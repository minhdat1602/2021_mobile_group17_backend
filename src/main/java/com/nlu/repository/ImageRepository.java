package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
	List<ImageEntity> findAll();

	ImageEntity findById(long id);

	<S extends ImageEntity> S save(S entity);

	void delete(ImageEntity imageEntity);

	void deleteById(Long id);


	boolean existsById(Long id);
}
