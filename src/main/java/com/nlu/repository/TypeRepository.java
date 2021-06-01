package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.TypeEntity;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
	List<TypeEntity> findAll();

	TypeEntity findById(long id);

	<S extends TypeEntity> S save(S entity);

	void delete(TypeEntity typeEntity);

	void deleteById(Long id);

	boolean existsById(Long id);
}
