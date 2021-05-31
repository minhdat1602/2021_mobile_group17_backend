package com.nlu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.common.ERole;
import com.nlu.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	Optional<RoleEntity> findByCode(ERole code);

	List<RoleEntity> findAll();
	
	RoleEntity findById(long id);

	<S extends RoleEntity> S save(S entity);

	void delete(RoleEntity roleEntity);
}
