package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.TypeEntity;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long>{
	List<TypeEntity> findAll();
}
