package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	List<CategoryEntity> findAll();

	CategoryEntity findById(long id);

	<S extends CategoryEntity> S save(S entity);

	void delete(CategoryEntity scategoryEntity);
}
