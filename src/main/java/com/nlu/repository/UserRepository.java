package com.nlu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmail(String email);

	Boolean existsByEmail(String email);

	List<UserEntity> findAll();

	UserEntity findById(long id);

	void delete(UserEntity userEntity);

	<S extends UserEntity> S save(S entity);
}
