package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nlu.entity.ProductEntity;

public interface ProductCustomRepository extends JpaSpecificationExecutor<ProductEntity>{
	List<ProductEntity> findByName(String name);
}
