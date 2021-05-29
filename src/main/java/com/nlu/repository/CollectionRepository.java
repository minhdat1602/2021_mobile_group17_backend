package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CollectionEntity;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity, Long>{
	List<CollectionEntity> findByBrand(long brandId);
}
